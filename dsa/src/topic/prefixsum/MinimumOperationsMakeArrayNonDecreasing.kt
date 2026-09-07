package topic.prefixsum

/**
 * 3914. Minimum Operations to Make Array Non Decreasing
 * Time: O(n)
 * Space: O(1)
 */
class MinimumOperationsMakeArrayNonDecreasing {
    fun minOperations(nums: IntArray): Long {
        val n = nums.size
        var ans = 0L
        for (i in 1 until n) {
            val diff = nums[i] - nums[i - 1]
            if (diff < 0) {
                ans -= diff.toLong()
            }
        }
        return ans
    }
}