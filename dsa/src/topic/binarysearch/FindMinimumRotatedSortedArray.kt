package topic.binarysearch

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Time: O(log(n))
 * Space: O(1)
 */
class FindMinimumRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = l + (r - l) / 2
            if (nums[mid] < nums[r]) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return nums[l]
    }
}