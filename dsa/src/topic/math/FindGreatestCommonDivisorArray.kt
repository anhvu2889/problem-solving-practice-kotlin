package topic.math

/**
 * 1979. Find Greatest Common Divisor of Array
 * Time: O(n + log(min))
 * Space: O(1)
 */
class FindGreatestCommonDivisorArray {
    fun findGCD(nums: IntArray): Int {
        var min = nums[0]
        var max = nums[1]
        for (num in nums) {
            min = minOf(min, num)
            max = maxOf(max, num)
        }
        return gcd(max, min)
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = x % y
            x = y
            y = temp
        }
        return x
    }
}