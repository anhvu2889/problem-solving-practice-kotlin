IMPORTANT: Do not explore project. Do not read any file except staged Kotlin files.

Steps:
1. Run: git diff --cached --name-only (get staged files)
   If empty, run: git status --short (get modified files)
2. Read ONLY those .kt files
3. Extract problem number and name from top comment
4. git add -A && git commit && git push && gh pr create
