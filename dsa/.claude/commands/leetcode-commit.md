IMPORTANT: Do not explore project. Only read the files identified below.

1. Get changed .kt files to extract problem info:
   Run: git status --short
   Filter only lines ending with .kt (M, A, ?? status)

2. Read ONLY those .kt files

3. Extract problem number and name from top comment:
   /**
    * 2574. Left and Right Sum Differences
    */

4. Stage and commit ALL changed files:
   Run: git add -A
   Commit with EXACTLY this format:
   Solved leetcode problem:
   {number}. {problem name}

   {index}. {number}. {problem name}

5. git push

6. Create PR:
   gh pr create \
     --title "Solved: {number}. {problem name}" \
     --body "## Problems Solved
   {index}. [{number}. {problem name}](https://leetcode.com/problems/{slug}/)" \
     --base main
