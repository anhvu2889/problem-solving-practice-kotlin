package topic.math

/**
 * 3345. Smallest Divisible Digit Product I
 * Time: O(1)
 * Space: O(1)
 */
class SmallestDivisibleDigitProductI {
    fun smallestNumber(n: Int, t: Int): Int {
        var num = n
        while (true) {
            if ((num % 10) % t == 0)
                return num
            var product = 1
            var temp = num
            while (temp > 0) {
                val digit = temp % 10
                product *= digit
                temp /= 10
            }
            if (product % t == 0)
                return num
            else num++
        }
    }
}