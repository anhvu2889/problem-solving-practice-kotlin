package top150.array

/**
 * 55. Jump Game
 * Time: O(n)
 * Space: O(1)
 */
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var maxIndex = nums[0]
        for (i in 1 until nums.size) {
            if (i > maxIndex)
                return false
            maxIndex = maxOf(maxIndex, i + nums[i])
            if (maxIndex >= nums.size - 1)
                return true
        }
        return maxIndex >= nums.size - 1
    }
}