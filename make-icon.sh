#!/data/data/com.termux/files/usr/bin/bash
# make-icon.sh — generate dot-matrix launcher icons from a grid
# Run from repo root. Requires: pkg install imagemagick

set -euo pipefail

RES="app/src/main/res"
OUT=$(mktemp -d)

# ---- THE GRID ----
# X = dot, . = empty. Edit this to change the icon shape.
# This is a single earbud (stem + body), 9x13 grid.
GRID=$(cat <<'EOF'
............
............
....XXXXXX..
....XXXXXX..
....XXXXXX..
....X....X..
....X....X..
....X....X..
..XXX..XXX..
..XX...XX...
............
............
EOF
)
# ---- RENDER ----
# 1. Build an SVG: one <circle> per 'X'
SVG="$OUT/icon.svg"
{
  echo '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100">'
  echo '<rect width="100" height="100" fill="#000000"/>'
  rows=$(echo "$GRID" | wc -l)
  cols=$(echo "$GRID" | awk '{ if (length > max) max = length } END { print max }')
  cell=100
  # cell size = min(100/cols, 100/rows); center grid
  read -r cell ox oy < <(awk -v c="$cols" -v r="$rows" 'BEGIN {
    s = (100/c < 100/r) ? 100/c : 100/r;
    ox = (100 - s*c)/2;
    oy = (100 - s*r)/2;
    print s, ox, oy
  }')
  dot_r=$(awk -v s="$cell" 'BEGIN { print s*0.42 }')
  i=0
  while IFS= read -r row; do
    j=0
    while [ $j -lt ${#row} ]; do
      ch="${row:$j:1}"
      if [ "$ch" = "X" ]; then
        cx=$(awk -v s="$cell" -v ox="$ox" -v j="$j" 'BEGIN { print ox + s*j + s/2 }')
        cy=$(awk -v s="$cell" -v oy="$oy" -v i="$i" 'BEGIN { print oy + s*i + s/2 }')
        echo "<circle cx=\"$cx\" cy=\"$cy\" r=\"$dot_r\" fill=\"#FFFFFF\"/>"
      fi
      j=$((j+1))
    done
    i=$((i+1))
  done <<< "$GRID"
  echo '</svg>'
} > "$SVG"

# 2. Rasterize the SVG at 1024x1024 (needs rsvg or inkscape; else skip SVG path)
if command -v rsvg-convert >/dev/null; then
  rsvg-convert -w 1024 -h 1024 "$SVG" -o "$OUT/icon-1024.png"
elif command -v convert >/dev/null; then
  # imagemagick can rasterize basic SVG
  convert -background none "$SVG" -resize 1024x1024 "$OUT/icon-1024.png"
fi

# 3. Resize to each mipmap
declare -A SIZES=(
  [mipmap-mdpi]=48
  [mipmap-hdpi]=72
  [mipmap-xhdpi]=96
  [mipmap-xxhdpi]=144
  [mipmap-xxxhdpi]=192
)

for dir in "${!SIZES[@]}"; do
  size="${SIZES[$dir]}"
  mkdir -p "$RES/$dir"
  convert "$OUT/icon-1024.png" -resize "${size}x${size}" "$RES/$dir/ic_launcher.png"
  # round variant: crop into a circle
  convert "$OUT/icon-1024.png" -resize "${size}x${size}" \
    \( +clone -alpha extract \
       -draw "fill black polygon 0,0 0,${size} ${size},${size} ${size},0" \
       -fill white -draw "circle $((size/2)),$((size/2)) $((size/2)),0" \
    \) -alpha off -compose CopyOpacity -composite \
    "$RES/$dir/ic_launcher_round.png"
done

# 4. Adaptive icon (mipmap-anydpi-v26)
mkdir -p "$RES/mipmap-anydpi-v26"
cat > "$RES/mipmap-anydpi-v26/ic_launcher.xml" <<'XML'
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/ic_launcher_background"/>
    <foreground android:drawable="@drawable/ic_launcher_foreground"/>
</adaptive-icon>
XML
cp "$RES/mipmap-anydpi-v26/ic_launcher.xml" "$RES/mipmap-anydpi-v26/ic_launcher_round.xml"

# 5. Adaptive icon background color + foreground drawable
mkdir -p "$RES/values" "$RES/drawable"
# background = solid black
grep -q 'ic_launcher_background' "$RES/values/colors.xml" 2>/dev/null || \
  cat > "$RES/values/colors.xml" <<'XML'
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="ic_launcher_background">#000000</color>
</resources>
XML

# foreground = the dot matrix on a transparent 108x108 canvas
# Android adaptive foreground: 108dp canvas, safe zone is center 72dp
convert "$OUT/icon-1024.png" -resize 512x512 -background none -gravity center -extent 768x768 \
  "$RES/drawable/ic_launcher_foreground.png"

echo "Icons written to $RES"
echo "Cleanup: $OUT"
