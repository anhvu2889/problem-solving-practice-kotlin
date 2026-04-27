package blind75.dp

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * Time:
 * Space:
 */
class BestTimeBuySellStockTransactionFee {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var noStockBalance = 0
        var hasStockBalance = -prices[0]
        for (i in 1 until prices.size) {
            val price = prices[i]
            val lastNoStockBalance = noStockBalance
            noStockBalance = maxOf(noStockBalance, hasStockBalance + price - fee)
            hasStockBalance = maxOf(hasStockBalance, lastNoStockBalance - price)
        }
        return noStockBalance
    }
}