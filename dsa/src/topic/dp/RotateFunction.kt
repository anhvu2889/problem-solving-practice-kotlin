package topic.dp

/**
 * 396. Rotate Function
 * Time: O(n)
 * Space: O(1)
 */
class RotateFunction {
    fun maxRotateFunction(nums: IntArray): Int {
        val n = nums.size
        var curSum = 0
        var sum = 0
        for (i in 0 until n) {
            curSum += i * nums[i]
            sum += nums[i]
        }
        var max = curSum
        for (i in 1 until n) {
            curSum = curSum + sum - n * nums[n - i]
            max = maxOf(max, curSum)
        }
        return max
    }
}