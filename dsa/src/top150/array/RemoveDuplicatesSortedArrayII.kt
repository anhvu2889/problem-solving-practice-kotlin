package top150.array

/**
 * 80. Remove Duplicates from Sorted Array II
 * Time: O(n)
 * Space: O(1)
 */
class RemoveDuplicatesSortedArrayII {
    fun removeDuplicates(nums: IntArray): Int {
        var w = 0
        for (r in nums.indices) {
            if (w < 2 || nums[r] != nums[w - 2]) {
                nums[w] = nums[r]
                w++
            }
        }
        return w
    }
}