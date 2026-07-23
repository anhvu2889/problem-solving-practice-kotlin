package top150.dp

/**
 * 198. House Robber
 * Time: O(n)
 * Space: O(1)
 */
class HouseRobber {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        var lastSkipped = 0
        var lastRobbed = nums[0]
        var maxRobbed = nums[0]
        for (i in 1 until n) {
            maxRobbed = maxOf(lastSkipped + nums[i], lastRobbed)
            lastSkipped = lastRobbed
            lastRobbed = maxRobbed
        }
        return maxRobbed
    }
}