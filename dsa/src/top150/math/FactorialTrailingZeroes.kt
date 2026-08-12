package top150.math

/**
 * 172. Factorial Trailing Zeroes
 * Time: O(log(n))
 * Space: O(1)
 */
class FactorialTrailingZeroes {
    fun trailingZeroes(n: Int): Int {
        var num = n
        var zeroes = 0
        while (num > 0) {
            num /= 5
            zeroes += num
        }
        return zeroes
    }
}