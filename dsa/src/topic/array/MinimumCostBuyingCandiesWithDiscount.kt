package topic.array

/**
 * 2144. Minimum Cost of Buying Candies With Discount
 * Time: O(n * log(n))
 * Space: O(1)
 */
class MinimumCostBuyingCandiesWithDiscount {
    fun minimumCost(cost: IntArray): Int {
        cost.sortDescending()
        var sum = 0
        for (i in cost.indices) {
            if (i >= 2 && i % 3 == 2)
                continue
            sum += cost[i]
        }
        return sum
    }
}