package topic.dp

import kotlin.math.abs

/**
 * 2770. Maximum Number of Jumps to Reach the Last Index
 * Time: O(n ^ 2)
 * Space: O(n)
 */
class MaximumNumberJumpsReachLastIndex {
    fun maximumJumps(nums: IntArray, target: Int): Int {
        val n = nums.size
        val dp = IntArray(n) {-1}
        dp[0] = 0
        for (i in nums.indices) {
            if (dp[i] == -1)
                continue
            for (j in i + 1 until n) {
                if (abs(nums[j] - nums[i]) <= target) {
                    dp[j] = maxOf(dp[j], dp[i] + 1)
                }
            }
        }
        return dp[n - 1]
    }
}