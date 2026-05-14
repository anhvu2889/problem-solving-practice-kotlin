package topic.slidingwindow

/**
 * 209. Minimum Size Subarray Sum
 * Time: O(n)
 * Space: O(1)
 */
class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var sum = 0
        var minLength = Int.MAX_VALUE
        for (r in nums.indices) {
            sum += nums[r]
            while (sum >= target) {
                minLength = minOf(minLength, r -  l + 1)
                sum -= nums[l]
                l++
            }
        }
        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }
}