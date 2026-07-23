package top150.dp

/**
 * 139. Word Break
 * Time: O(n * maxLen)
 * Space: O(n + m)
 */
class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = HashSet<String>()
        var maxLen = 0
        val n = s.length
        for (word in wordDict) {
            wordSet.add(word)
            maxLen = maxOf(maxLen, word.length)
        }
        val dp = BooleanArray(n + 1)
        dp[0] = true
        for (i in 1..n) {
            val lowest = maxOf(0, i - maxLen)
            for (j in i - 1 downTo lowest) {
                if (dp[j] && s.substring(j, i) in wordSet) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[n]
    }
}