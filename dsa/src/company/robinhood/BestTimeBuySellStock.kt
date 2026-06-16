package company.robinhood

/**
 * 121. Best Time to Buy and Sell Stock
 * Time: O(n)
 * Space: O(1)
 */
class BestTimeBuySellStock {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var maxProfit = 0
        for (price in prices) {
            if (price < buy) {
                buy = price
            } else {
                maxProfit = maxOf(maxProfit, price - buy)
            }
        }
        return maxProfit
    }
}