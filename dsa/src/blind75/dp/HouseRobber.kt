package blind75.dp

/**
 * 198. House Robber
 * Time: O(n)
 * Space: O(1)
 */
class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1)
            return nums[0]
        var prev2 = nums[0]
        var prev1 = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            val cur = maxOf(prev1, nums[i] + prev2)
            prev2 = prev1
            prev1 = cur
        }
        return prev1
    }
}