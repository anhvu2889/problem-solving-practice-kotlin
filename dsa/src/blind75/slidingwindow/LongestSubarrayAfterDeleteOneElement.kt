package blind75.slidingwindow

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 * Time: O(n)
 * Space: O(1)
 */
class LongestSubarrayAfterDeleteOneElement {
    fun longestSubarray(nums: IntArray): Int {
        var l = 0
        var max = 0
        var count = 0
        for (r in nums.indices) {
            if (nums[r] == 0)
                count++
            while (count > 1) {
                if (nums[l] == 0) {
                    count--
                }
                l++
            }
            max = maxOf(max, r - l)
        }
        return max
    }
}