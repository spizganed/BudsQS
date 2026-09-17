NEXT SESSION — START HERE
=====================================================================

Written 2026-09-18. Read your memory first (it is long and current), then
HANDOFF.md.

COMMIT FIRST
---------------------------------------------------------------------
The 2026-09-18 work is BUILT, SIGNED AND INSTALLED and sits in the working tree
uncommitted. The message is written to a file:

    cd /storage/emulated/0/Android/data/com.tyron.code/files/codeassist/projects/BudsQS
    git add -A && git commit -F commit-title-short.txt && git push

`-F` avoids CodeAssist's commit box, which is too small for a full message.


WHAT WAS DONE 2026-09-18
---------------------------------------------------------------------
1. THE ICONS ARE THE USER'S OWN SVGs, COPIED VERBATIM. `svgs/case.svg`,
   `svgs/bud_left.svg`, `svgs/bud_right.svg` -> the three drawables, path data
   character for character, source viewBox kept. Do NOT rescale or re-transcribe
   them; that mistake was made three times and produced wrong artwork.
2. SIZING RULES, each learned from a real failure: layout size (not viewBox) in
   android:width/height, or the widget builds 400MB of bitmaps and the app crashes
   on connect; explicit widths from the true ratio, because wrap_content +
   adjustViewBounds clips the art (intrinsic size rounds to whole PIXELS).
3. BATTERY CARD IS NOW TWO CARDS stacked (icons above, bars below), so resizing
   one does not move the other. Both fade+collapse when disconnected.
4. HEADER CONNECTION PILL: dot + word beside the device name, cross-fading.
5. ANIMATIONS: icons fade+scale on show/hide, the case also lifts, the buds slide
   together when the case is hidden, cards collapse, bars fade, widget pill fades.
6. TOASTS OFF for connect/disconnect, at his request.
7. BAR CELLS have rounded edges (rounded divider slots).
8. WIDGET: "Can't load widget" WAS THE VECTOR previewImage. Removed. The widget
   now shows a connection pill instead of a blank card when disconnected.


1. VERIFY THE WIDGET, FIRST THING
---------------------------------------------------------------------
The previewImage fix is the identified cause of "Can't load widget" but is NOT
yet confirmed on device.

    - long-press the home screen -> Widgets, and check the picker no longer
      shows "Can't load widget"
    - place one, then Dev Tools -> Widg, and send
      Downloads/QuickBudsShot/layout_widget_<ts>.txt

If the picker is fixed, the fallback (a real BITMAP preview) can be added later.
Never a vector.


2. THE REMAINING TASKS
---------------------------------------------------------------------
a. ANC GESTURE PUSH-BACK — the ANC buttons should track a mode changed by the
   buds' own gesture, exactly as game mode already does. HE MUST SEND A LOG after
   cycling through each ANC setting by gesture; the push format is not captured
   yet. Do not guess at it.

b. LAUNCHER / PACKAGE ICON from the same three SVGs. `ic_launcher_foreground.xml`
   still traces the OLD bud artwork.

c. LIGHT THEME REMOVAL — decided, not started.

d. targetSdk 35 edge-to-edge warning appeared in the last build (content draws
   behind the status/nav bars). Unexamined.

e. Case LID state is NOT readable: the firmware never reports it, BudsService only
   infers it. Reading it properly needs a hardware request that has not been
   captured. **The case ICON must stay visible regardless** — he restated that.


PROCESS NOTES THAT SAVED REAL TIME
---------------------------------------------------------------------
- READ `testlogs/layout_*.txt` OR THE WIDGET REPORT BEFORE CHANGING ANY LAYOUT.
  It caught the clipping bug, the icon overlap, and the blank-widget cause.
- The widget report's SIZES are exact but its POSITIONS are meaningless (detached
  view tree). Do not re-add a position walk.
- The diagnostic itself crashed the app twice (null LayoutParams;
  getResourceEntryName on View.NO_ID). It is now fully wrapped in try/catch and
  writes any trace into the report. Keep it that way.
- Sketch a layout as ASCII and get an explicit yes/no BEFORE coding. That is what
  stopped this project burning build cycles on guessed layouts.
- XML comments: no `--`, and they MUST end with `-->`.
