package top150.array

/**
 * 45. Jump Game II
 * Time: O(n)
 * Space: O(1)
 */
class JumpGameII {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var currentJumpEnd = 0
        var nextJumpMaxReach = 0
        for (i in 0 until nums.lastIndex) {
            nextJumpMaxReach = maxOf(nextJumpMaxReach, i + nums[i])
            if (i == currentJumpEnd) {
                jumps++
                currentJumpEnd = nextJumpMaxReach
            }
        }
        return jumps
    }
}