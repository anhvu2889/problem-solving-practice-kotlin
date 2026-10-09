package topic.backtracking

/**
 * 301. Remove Invalid Parentheses
 * Time: O(2 ^ n)
 * Space: O(n * 2 ^ n)
 */
class RemoveInvalidParentheses {
    fun removeInvalidParentheses(s: String): List<String> {
        val (overOpen, overClose) = countOver(s)
        val path = StringBuilder()
        val ans = HashSet<String>()
        dfs(s, 0, 0, overOpen, overClose, path, ans)
        return ans.toList()
    }

    private fun countOver(s: String): Pair<Int, Int> {
        var overOpen = 0
        var overClose = 0
        for (c in s) {
            if (c == '(') overOpen++
            else if (c == ')') {
                if (overOpen == 0) overClose++
                else overOpen--
            }
        }
        return Pair(overOpen, overClose)
    }

    private fun dfs(
        s: String,
        i: Int,
        open: Int,
        overOpen: Int,
        overClose: Int,
        path: StringBuilder, ans: HashSet<String>
    ) {
        if (i == s.length) {
            if (open == 0 && overOpen == 0 && overClose == 0) ans.add(path.toString())
            return
        }
        val c = s[i]
        if (c == '(' && overOpen > 0) dfs(s, i + 1, open, overOpen - 1, overClose, path, ans)
        if (c == ')' && overClose > 0) dfs(s, i + 1, open, overOpen, overClose - 1, path, ans)
        if (c == ')' && open == 0) return
        var nextOpen = open  // open after keeping c
        if (c == '(') nextOpen = open + 1
        else if (c == ')') nextOpen = open - 1
        path.append(c)
        dfs(s, i + 1, nextOpen, overOpen, overClose, path, ans)
        path.deleteCharAt(path.length - 1)
    }
}