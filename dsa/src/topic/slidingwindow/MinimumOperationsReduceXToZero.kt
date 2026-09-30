package topic.slidingwindow

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * Time: O(n)
 * Space: O(1)
 */
class MinimumOperationsReduceXToZero {
    fun minOperations(nums: IntArray, x: Int): Int {
        val n = nums.size
        var totalSum = 0
        for (num in nums) {
            totalSum += num
        }
        val remainSum = totalSum - x
        if (remainSum < 0) {
            return -1
        }
        if (remainSum == 0) {
            return n
        }
        val maxLenOfRemain = findLengthOfLongestSubarray(nums, remainSum)
        return if (maxLenOfRemain == -1) -1 else n - maxLenOfRemain
    }

    private fun findLengthOfLongestSubarray(nums: IntArray, target: Int): Int {
        var l = 0
        var sum = 0
        var maxLen = -1
        for (r in nums.indices) {
            sum += nums[r]
            while (sum > target) {
                sum -= nums[l]
                l++
            }
            if (sum == target) {
                maxLen = maxOf(r - l + 1, maxLen)
            }
        }
        return maxLen
    }
}