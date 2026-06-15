IMPORTANT: Do not explore project. Do not read any file except staged Kotlin files.

Steps:
1. Run: git diff --cached --name-only (get staged files)
   If empty, run: git status --short (get modified files)
2. Read ONLY those .kt files
3. Extract problem number and name from top comment
4. git add -A && git commit && git push
5. Create PR with EXACTLY this command (no AI-generated description):
gh pr create \
  --title "Solved: {number}. {problem name}" \
  --body "## Problems Solved
{index}. [{number}. {problem name}](https://leetcode.com/problems/{slug}/)" \
  --base main
