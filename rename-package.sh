#!/data/data/com.termux/files/usr/bin/bash
# rename-package.sh — rename an Android/Kotlin package across a project
#
# Usage: ./rename-package.sh <repo-path> <old-package> <new-package>
# Example: ./rename-package.sh ~/budsqs-work/budsqs \
#            com.example.oneplusbudsqs com.spizganed.quickbuds

set -euo pipefail

REPO="${1:?repo path required}"
OLD="${2:?old package required}"
NEW="${3:?new package required}"

cd "$REPO"

# Sanity: must be a git repo on a clean-ish working tree
git rev-parse --is-inside-work-tree >/dev/null
if ! git diff --quiet || ! git diff --cached --quiet; then
  echo "ERROR: working tree is dirty. Commit or stash first."
  exit 1
fi

OLD_PATH="app/src/main/kotlin/${OLD//.//}"
NEW_PATH="app/src/main/kotlin/${NEW//.//}"

echo "Repo:      $REPO"
echo "Old pkg:   $OLD"
echo "New pkg:   $NEW"
echo "Old path:  $OLD_PATH"
echo "New path:  $NEW_PATH"
echo

# 1. Create a working branch
BRANCH="rename/${NEW##*.}"
git checkout -b "$BRANCH"

# 2. Move source folder
if [ -d "$OLD_PATH" ]; then
  mkdir -p "$NEW_PATH"
  # move contents, preserving subdirs
  find "$OLD_PATH" -mindepth 1 -maxdepth 1 -exec git mv {} "$NEW_PATH/" \;
  # clean up now-empty old dirs up to app/src/main/kotlin
  rmdir -p "$OLD_PATH" 2>/dev/null || true
else
  echo "WARN: $OLD_PATH does not exist — skipping folder move"
fi

# 3. Replace package strings in all Kotlin/Java files
echo "Rewriting package/import references..."
grep -rl --include='*.kt' --include='*.java' "$OLD" app/src 2>/dev/null | while read -r f; do
  sed -i "s/${OLD//./\\.}/${NEW}/g" "$f"
done

# 4. Replace in build.gradle.kts / manifest / any other text files that mention it
for f in app/build.gradle.kts app/src/main/AndroidManifest.xml settings.gradle.kts; do
  [ -f "$f" ] && sed -i "s/${OLD//./\\.}/${NEW}/g" "$f"
done

# 5. Report stragglers
echo
echo "=== Remaining references to $OLD (should be none) ==="
grep -rn --include='*.kt' --include='*.java' --include='*.xml' --include='*.kts' "$OLD" . 2>/dev/null || echo "(none)"

echo
echo "=== Files changed on branch $BRANCH ==="
git status --short

echo
echo "Next steps:"
echo "  1. ./gradlew assembleDebug"
echo "  2. Install + smoke test widget, QS tile, foreground service"
echo "  3. git commit -am 'Rename package to $NEW'"
echo "  4. git checkout main && git merge $BRANCH"
