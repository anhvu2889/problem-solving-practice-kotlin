package topic.math

/**
 * 1464. Maximum Product of Two Elements in an Array
 * Time: O(n)
 * Space: O(1)
 */
class MaximumProductTwoElementsArray {
    fun maxProduct(nums: IntArray): Int {
        var first = Int.MIN_VALUE
        var second = Int.MIN_VALUE
        for (num in nums) {
            if (num > first) {
                second = first
                first = num
            } else if (num > second) {
                second = num
            }
        }
        return (first - 1) * (second - 1)
    }
}