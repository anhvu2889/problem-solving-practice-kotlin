package blind75.twopointers

/**
 * 283. Move Zeroes
 * Time: O(n)
 * Space: O(1)
 */
class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var w = 0
        for (num in nums) {
            if (num != 0)
                nums[w++] = num
        }
        while (w < nums.size) {
            nums[w] = 0
            w++
        }
    }
}