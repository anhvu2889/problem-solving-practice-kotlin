package blind75.dp

import kotlin.math.cos
import kotlin.math.min

/**
 * 746. Min Cost Climbing Stairs
 * Time: O(n)
 * Space: O(1)
 */
class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        var prev2 = cost[0]
        var prev1 = cost[1]
        for(i in 2 until n) {
            val cur = min(prev1 + cost[i], prev2 + cost[i])
            prev2 = prev1
            prev1 = cur
        }
        return min(prev1, prev2)
    }
}