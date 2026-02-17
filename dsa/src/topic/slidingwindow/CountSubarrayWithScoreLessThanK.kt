package topic.slidingwindow

/**
 * 2302. Count Subarrays With Score Less Than K
 * Time: O(n)
 * Space: O(1)
 */
class CountSubarrayWithScoreLessThanK {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        var l = 0
        var sum = 0L
        var score = 0L
        var count = 0L
        for (r in nums.indices) {
            sum += nums[r]
            score = sum * (r - l + 1)
            while (l <= r && score >= k) {
                sum -= nums[l]
                l++
                score = sum * (r - l + 1)
            }
            count += r - l + 1
        }
        return count
    }
}