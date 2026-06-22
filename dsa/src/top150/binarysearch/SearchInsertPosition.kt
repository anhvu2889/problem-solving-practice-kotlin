package top150.binarysearch

/**
 * 35. Search Insert Position
 * Time: O(log(n))
 * Space: O(1)
 */
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (nums[mid] == target)
                return mid
            else if (nums[mid] > target)
                r = mid - 1
            else
                l = mid + 1
        }
        return l
    }
}