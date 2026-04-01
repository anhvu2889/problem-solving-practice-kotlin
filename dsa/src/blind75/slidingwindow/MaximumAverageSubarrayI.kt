package blind75.slidingwindow

/**
 * 643. Maximum Average Subarray I
 * Time: O(n)
 * Space: O(1)
 */
class MaximumAverageSubarrayI {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0.0
        for (i in 0..<k) {
            sum += nums[i]
        }
        var max = sum
        for (i in k..<nums.size) {
            sum = sum - nums[i - k] + nums[i]
            max = maxOf(max, sum)
        }
        return max / k
    }
}