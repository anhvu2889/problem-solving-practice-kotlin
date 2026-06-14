package topic.prefixsum

import kotlin.math.abs

/**
 * 2574. Left and Right Sum Differences
 * Time: O(n)
 * Space: O(n)
 */
class LeftRightSumDifferences {
    fun leftRightDifference(nums: IntArray): IntArray {
        val n = nums.size
        val left = IntArray(n)
        for (i in 1 until n) {
            left[i] = left[i - 1] + nums[i - 1]
        }
        val right = IntArray(n)
        for (i in 1 until n) {
            right[n - 1 - i] = right[n - i] + nums[n - i]
        }
        val ans = IntArray(n)
        for (i in ans.indices) {
            ans[i] = abs(left[i] - right[i])
        }
        return ans
    }
}