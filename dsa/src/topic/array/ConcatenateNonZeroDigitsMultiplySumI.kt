package topic.array

/**
 * 3754. Concatenate Non-Zero Digits and Multiply by Sum I
 * Time: O(n)
 * Space: O(1)
 */
class ConcatenateNonZeroDigitsMultiplySumI {
    fun sumAndMultiply(n: Int): Long {
        var num = n
        var x = 0
        var sum = 0L
        var numOfZero = 1
        while (num > 0) {
            val digit = num % 10
            if (digit != 0) {
                x += digit * numOfZero
                numOfZero *= 10
            }
            sum += digit.toLong()
            num /= 10
        }
        return x * sum
    }
}