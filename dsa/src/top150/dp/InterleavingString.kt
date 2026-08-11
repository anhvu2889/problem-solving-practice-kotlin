package top150.dp

/**
 * 97. Interleaving String
 * Time: O(n1 * n2)
 * Space: O(min(n1, n2))
 */
class InterleavingString {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n1 = s1.length
        val n2 = s2.length
        val n3 = s3.length
        if (n1 + n2 != n3)
            return false
        if (n2 > n1)
            return isInterleave(s2, s1, s3)
        val dp = BooleanArray(n2 + 1)
        dp[0] = true
        for (j in 1..n2) {
            if (s2[j - 1] == s3[j - 1])
                dp[j] = true
            else
                break

        }
        for (i in 1..n1) {
            dp[0] = dp[0] && s1[i - 1] == s3[i - 1]
            for (j in 1..n2) {
                val fromS1 = dp[j] && s1[i - 1] == s3[i + j - 1]
                val fromS2 = dp[j - 1] && s2[j - 1] == s3[i + j - 1]
                dp[j] = fromS1 || fromS2
            }
        }
        return dp[n2]
    }
}