package blind75.dp

/**
 * 72. Edit Distance
 * Time: O(m * n)
 * Space: O(m * n)
 */
class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val l1 = word1.length
        val l2 = word2.length
        val dp = Array(l1 + 1) { IntArray(l2 + 1) }
        for (i in 0..l1) {
            dp[i][0] = i
        }
        for (i in 0..l2) {
            dp[0][i] = i
        }
        for (i1 in 1..l1) {
            for (i2 in 1..l2) {
                if (word1[i1 - 1] == word2[i2 - 1])
                    dp[i1][i2] = dp[i1 - 1][i2 - 1]
                else {
                    dp[i1][i2] = 1 + minOf(dp[i1 - 1][i2], dp[i1][i2 - 1], dp[i1 - 1][i2 - 1])
                }
            }
        }
        return dp[l1][l2]
    }
}