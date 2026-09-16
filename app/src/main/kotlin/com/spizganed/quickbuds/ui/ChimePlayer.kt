package com.spizganed.quickbuds.ui

import android.content.Context
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import kotlin.math.PI
import kotlin.math.sin

/**
 * Plays a short locating chime on ONE side of the earbuds.
 *
 * GENERATED, NOT A FILE
 * The request left the source open ("you generate or we use free copyright
 * sounds"). Generating wins here: no asset to ship or license, nothing to
 * download over a link we are trying to keep idle, and — the deciding factor —
 * full control over level and envelope, which is what the driver-safety
 * requirement is actually about.
 *
 * HOW ONE SIDE ONLY
 * The buds are a stereo sink, so "one bud" means one CHANNEL. The buffer is
 * interleaved stereo and the unwanted channel is written as exact ZERO. That is
 * deliberate: it means the other bud's driver receives silence rather than a
 * quiet signal, which volume-balance-based panning could not guarantee. The
 * consequence is that the chime is perceived at roughly half loudness, which is
 * an acceptable trade for the guarantee.
 *
 * LEVELS — the driver-safety requirement, taken literally
 *   - MAX_AMPLITUDE is 0.25 of full scale (a 12 dB pad below digital full scale).
 *     A locating chime does not need to be loud; it needs to be audible in a
 *     quiet room with a bud lying on a table.
 *   - The tone is a 660 Hz sine. A sine has no harmonics to excite a driver's
 *     resonance, unlike a square or an alarm-style two-tone. Pitch is fixed and
 *     low-mid, not high, because high frequencies are what stress a small
 *     driver's diaphragm.
 *   - 20 ms raised-cosine fade in and out on every tone pulse. A hard start or
 *     stop on a speaker is a step discontinuity, i.e. a click, which is
 *     mechanically harder on a driver than the tone itself.
 *   - Total duration is capped at MAX_MS and the pattern is pulsed (0.5 s on,
 *     0.7 s off) rather than continuous, so nothing is ever driven for long.
 *   - The Stream is STREAM_MUSIC at a fixed volume, not STREAM_ALARM: alarm
 *     streams can be routed at system alarm level and would ignore our ceiling.
 *
 * There is also an explicit stop(): the activity calls it in onStop, so a chime
 * cannot outlive the screen.
 */
class ChimePlayer(private val context: Context) {

    enum class Side { LEFT, RIGHT }

    companion object {
        /** 0.25 = 12 dB below full scale. Do not raise without re-reading the note above. */
        private const val MAX_AMPLITUDE = 0.25
        private const val TONE_HZ = 660.0
        private const val SAMPLE_RATE = 44100
        /** Fade length per pulse edge. */
        private const val FADE_MS = 20
        /** One pulse on, one gap off. */
        private const val ON_MS = 500
        private const val OFF_MS = 700
        /** Hard cap on total playback. */
        private const val MAX_MS = 10_000
    }

    @Volatile
    private var track: AudioTrack? = null

    @Volatile
    private var stopped = false

    private var thread: Thread? = null

    /** True while a chime is actually being rendered. */
    val isPlaying: Boolean get() = thread?.isAlive == true

    fun play(side: Side) {
        stop()
        stopped = false

        thread = Thread {
            val framesPerMs = SAMPLE_RATE / 1000.0
            val fadeFrames = (FADE_MS * framesPerMs).toInt()
            val onFrames = (ON_MS * framesPerMs).toInt()
            val offFrames = (OFF_MS * framesPerMs).toInt()
            val pulseFrames = onFrames + offFrames
            val totalPulses = MAX_MS / (ON_MS + OFF_MS)

            // Build the whole stereo buffer up front: one write, no re-entrancy,
            // and the loop below stays a pure render.
            val totalFrames = pulseFrames * totalPulses
            val buffer = ShortArray(totalFrames * 2)

            for (i in 0 until totalFrames) {
                val inPulse = i % pulseFrames
                var sample = 0.0
                if (inPulse < onFrames) {
                    val t = inPulse / SAMPLE_RATE.toDouble()
                    var env = 1.0
                    if (inPulse < fadeFrames) {
                        // Raised cosine: C1-continuous, so no click at the edge.
                        val x = inPulse.toDouble() / fadeFrames
                        env = 0.5 - 0.5 * kotlin.math.cos(PI * x)
                    } else if (inPulse > onFrames - fadeFrames) {
                        val x = (onFrames - inPulse).toDouble() / fadeFrames
                        env = 0.5 - 0.5 * kotlin.math.cos(PI * x)
                    }
                    sample = sin(2.0 * PI * TONE_HZ * t) * MAX_AMPLITUDE * env
                }

                val v = (sample * Short.MAX_VALUE).toInt().toShort()
                // Interleaved L,R. Silence in the channel we were not asked for.
                buffer[i * 2] = if (side == Side.LEFT) v else 0
                buffer[i * 2 + 1] = if (side == Side.RIGHT) v else 0
            }

            // Guard: a zero-length buffer is an IllegalArgumentException in
            // AudioTrack.write, so bail before constructing anything.
            if (buffer.isEmpty()) return@Thread

            val minBuf = AudioTrack.getMinBufferSize(
                SAMPLE_RATE,
                AudioFormat.CHANNEL_OUT_STEREO,
                AudioFormat.ENCODING_PCM_16BIT
            ).coerceAtLeast(buffer.size * 2)

            val t = AudioTrack(
                AudioManager.STREAM_MUSIC,
                SAMPLE_RATE,
                AudioFormat.CHANNEL_OUT_STEREO,
                AudioFormat.ENCODING_PCM_16BIT,
                minBuf,
                AudioTrack.MODE_STREAM
            )

            try {
                track = t
                t.play()
                var written = 0
                while (written < buffer.size && !stopped) {
                    // Chunked so stop() is responsive: a single 10 s write would
                    // block until the whole chime had been queued.
                    val chunk = minOf(4096, buffer.size - written)
                    val n = t.write(buffer, written, chunk)
                    if (n <= 0) break
                    written += n
                }
                // Let the tail drain, but never longer than the queued audio.
                if (!stopped) {
                    val remainingMs = ((buffer.size - written) / 2.0 / framesPerMs).toLong()
                    if (remainingMs in 1..MAX_MS.toLong()) Thread.sleep(remainingMs)
                }
            } catch (_: InterruptedException) {
                // stop() interrupts us; fall through to cleanup.
            } catch (_: IllegalStateException) {
                // Track was released underneath us; nothing to do.
            } finally {
                try {
                    if (t.playState != AudioTrack.PLAYSTATE_STOPPED) t.stop()
                } catch (_: IllegalStateException) {
                }
                try {
                    t.release()
                } catch (_: IllegalStateException) {
                }
                if (track === t) track = null
            }
        }.apply { isDaemon = true }.also { it.start() }
    }

    /** Stops immediately and discards anything queued. Safe to call repeatedly. */
    fun stop() {
        stopped = true
        thread?.interrupt()
        thread = null
        val t = track
        track = null
        if (t != null) {
            try {
                t.pause()
                t.flush()
            } catch (_: IllegalStateException) {
            }
        }
    }

    fun release() = stop()
}
