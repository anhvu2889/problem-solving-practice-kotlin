package top150.array

/**
 * 189. Rotate Array
 * Time: O(n)
 * Space: O(1)
 */
class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        val l =  k % nums.size
        rotate(nums, 0, nums.size - 1)
        rotate(nums, 0, l - 1)
        rotate(nums, l, nums.size - 1)
    }

    fun rotate(nums: IntArray, start: Int, end: Int) {
        var l = start
        var r = end
        while (l < r) {
            val temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
            l++
            r--
        }
    }
}