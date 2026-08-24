package topic.math

/**
 * 3622. Check Divisibility by Digit Sum and Product
 * Time: O(log(n))
 * Space: O(1)
 */
class CheckDivisibilityDigitSumProduct {
    fun checkDivisibility(n: Int): Boolean {
        var num = n
        var sum = 0
        var product = 1
        while (num > 0) {
            val digit = num % 10
            sum += digit
            product *= digit
            num /= 10
        }
        return n % (sum + product) == 0
    }
}