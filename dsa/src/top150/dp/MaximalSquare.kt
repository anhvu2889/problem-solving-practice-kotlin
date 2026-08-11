package top150.dp

/**
 * 221. Maximal Square
 * Time: O(m * n)
 * Space: O(n)
 */
class MaximalSquare {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val dp = IntArray(n)
        var max = 0
        for (r in 0..<m) {
            var diag = 0
            for (c in 0..<n) {
                val temp = dp[c]
                if (matrix[r][c] == '0') {
                    dp[c] = 0
                }
                else if (r == 0 || c == 0) {
                    dp[c] = 1
                    max = maxOf(dp[c], max)
                } else {
                    dp[c] = 1 + minOf(dp[c], dp[c - 1], diag)
                    max = maxOf(dp[c], max)
                }
                diag = temp
            }
        }
        return max * max
    }
}