package topic.twopointer

/**
 * 75. Sort Colors
I: 2 1 0 2 0 1
O: 0 0 1 1 2 2
From left to right:
If c = 2 -> swap to right
If c = 0 -> swap to left
 * Time: O(n)
 * Space: O(1)
 */
class SortColor {
    fun sortColors(nums: IntArray): Unit {
        var l = 0
        var r = nums.size - 1
        var i = 0
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l)
                l++
                i++
            } else if (nums[i] == 2) {
                swap(nums, i, r)
                r--
            } else if (nums[i] == 1) {
                i++
            }
        }
    }

    fun swap(nums: IntArray, l: Int, r: Int) {
        val temp = nums[l]
        nums[l] = nums[r]
        nums[r] = temp
    }
}