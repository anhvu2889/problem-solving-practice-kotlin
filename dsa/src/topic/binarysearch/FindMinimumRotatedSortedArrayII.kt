package topic.binarysearch

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * Time: O(log(n)
 * Space: O(1)
 */
class FindMinimumRotatedSortedArrayII {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = l + (r - l) / 2
            if (nums[mid] < nums[r]) {
                r = mid
            } else if (nums[mid] > nums[r]) {
                l = mid + 1
            } else {
                r--
            }
        }
        return nums[l]
    }
}