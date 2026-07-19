package top150.binarysearch

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
class FindMinimumRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        if (nums[l] < nums[r]) return nums[l]
        while (l < r) {
            val mid = l + (r - l) / 2
            if (nums[mid] > nums[r]) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return nums[l]
    }
}