package topic.array

/**
 * 3300. Minimum Element After Replacement With Digit Sum
 * Time: O(n * log(m))
 * Space: O(1)
 */
class MinimumElementAfterReplacemenWithDigitSum {
    fun minElement(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        for (i in nums.indices) {
            var num = nums[i]
            var sum = 0
            while (num > 0) {
                sum += num % 10
                num /= 10
            }
            min = minOf(sum, min)
        }
        return min
    }
}