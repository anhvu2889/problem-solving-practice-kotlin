package top150.array

/**
 * 122. Best Time to Buy and Sell Stock II
 * Time: O(n)
 * Space: O(1)
 */
class BestTimeBuySellStockII {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }
}