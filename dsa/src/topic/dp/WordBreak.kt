package topic.dp

/**
 * 139. Word Break
 */
class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toHashSet()
        val memo = HashMap<Int, Boolean>()
        return dfs(s, 0, wordSet, memo)
    }

    fun dfs(s: String, start: Int, wordSet: HashSet<String>, memo: HashMap<Int, Boolean>): Boolean {
        if (start == s.length)
            return true
        if (memo.containsKey(start))
            return memo[start]!!
        for (end in start + 1..s.length) {
            if (wordSet.contains(s.substring(start, end)) && dfs(s, end, wordSet, memo)) {
                memo[start] = true
                return true
            }
        }
        memo[start] = false
        return false
    }
}