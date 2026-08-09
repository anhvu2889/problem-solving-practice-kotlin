package top150.dp

/**
 * 72. Edit Distance
 * Time: O(n1 * n2)
 * Space: O(min(n1, n2))
 */
class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val n1 = word1.length
        val n2 = word2.length
        if (n1 < n2)
            return minDistance(word2, word1)
        val dp = IntArray(n2 + 1)
        for (i in 0..n2) {
            dp[i] = i
        }
        for (i in 1..n1) {
            var prev = dp[0]
            dp[0] = i
            for (j in 1..n2) {
                val temp = dp[j]
                if (word1[i - 1] == word2[j - 1]) {
                    dp[j] = prev
                } else {
                    dp[j] = 1 + minOf(dp[j], dp[j - 1], prev)
                }
                prev = temp
            }
        }
        return dp[n2]
    }
}