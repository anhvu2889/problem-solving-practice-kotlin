package topic.dp

/**
 * 152. Maximum Product Subarray
 * Time: O(n)
 * Space: O(1)
 */
class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var max = nums[0]
        var min = nums[0]
        var result = nums[0]
        for (i in 1 until nums.size) {
            val num = nums[i]
            if (num < 0) {
                val temp = max
                max = min
                min = temp
            }
            max = maxOf(num, max * num)
            min = minOf(num, min * num)
            result = maxOf(result, max)
        }
        return result
    }
}