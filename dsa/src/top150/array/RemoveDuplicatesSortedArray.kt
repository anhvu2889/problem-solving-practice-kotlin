package top150.array

/**
 * 26. Remove Duplicates from Sorted Array
 * Time: O(n)
 * Space: O(1)
 */
class RemoveDuplicatesSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var w = 1
        var prev = nums[0]
        for (r in 1 until nums.size) {
            if (nums[r] != prev) {
                prev = nums[r]
                nums[w] = prev
                w++
            }
        }
        return w
    }
}