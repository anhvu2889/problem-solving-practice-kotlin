package topic.array

/**
 * 1833. Maximum Ice Cream Bars
 * Time: O(m + n)
 * Space: O(m)
 */
class MaximumIceCreamBars {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        val n = 100_002
        val freq = IntArray(n)
        for (cost in costs) {
            freq[cost]++
        }
        var total = 0
        var remain = coins
        for (price in freq.indices) {
            if (remain < price)
                break
            if (freq[price] == 0)
                continue
            val canBuy = minOf(remain / price, freq[price])
            total += canBuy
            remain -= canBuy * price
        }
        return total
    }
}