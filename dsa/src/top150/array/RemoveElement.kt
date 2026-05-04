package top150.array

/**
 * 27. Remove Element
 * Time: O(n)
 * Space: O(1)
 */

class RemoveElement {
    fun removeElement(nums: IntArray, value: Int): Int {
        var w = 0
        var r = 0
        while (r < nums.size) {
            if (nums[r] != value) {
                nums[w] = nums[r]
                w++
            }
            r++
        }
        return w
    }
}