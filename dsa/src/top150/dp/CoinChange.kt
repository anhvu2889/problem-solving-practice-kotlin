package top150.dp

/**
 * 322. Coin Change
 * Time: O(n * k)
 * Space: O(k)
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val INF = amount + 1
        val dp = IntArray(amount + 1) { INF }
        dp[0] = 0
        for (x in 1..amount) {
            for (c in coins) {
                if (c <= x) {
                    dp[x] = minOf(dp[x], 1 + dp[x - c])
                }
            }
        }
        return if (dp[amount] == INF) -1 else dp[amount]
    }
}