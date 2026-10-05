package topic.slidingwindow

/**
 * 3652. Best Time to Buy and Sell Stock using Strategy
 * Time: O(n)
 * Space: O(n)
 */
class BestTimeBuySellStockStrategy {
    fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        val n = prices.size
        val original = LongArray(n + 1)
        for (i in 0 until n) {
            original[i + 1] = original[i] + strategy[i] * prices[i]
        }
        var max = original[n]
        var modification = 0L
        val mid = k / 2
        for (i in mid until k) {
            modification += prices[i]
        }
        var newProfit = modification + original[n] - original[k]
        max = maxOf(max, newProfit)

        for (start in 1..n - k) {
            modification -= prices[start + mid - 1]
            modification += prices[start + k - 1]
            newProfit = original[start] + modification + original[n] - original[start + k]
            max = maxOf(max, newProfit)
        }
        return max
    }
}