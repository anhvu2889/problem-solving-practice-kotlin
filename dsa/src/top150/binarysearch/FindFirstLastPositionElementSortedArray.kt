package top150.binarysearch

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Time: O(log(n))
 * Space: O(1)
 */
class FindFirstLastPositionElementSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = lowerBound(nums, target)
        if (first == nums.size || nums[first] != target)
            return intArrayOf(-1, -1)
        val last = lowerBound(nums, target + 1) - 1
        return intArrayOf(first, last)
    }

    private fun lowerBound(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size
        while (l < r) {
            val mid = l + (r - l) / 2
            if (nums[mid] >= target)
                r = mid
            else
                l = mid + 1
        }
        return l
    }
}