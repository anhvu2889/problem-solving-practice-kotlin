package topic.array

/**
 * 1056. Confusing Number
 * Time: O(n)
 * Space: O(1)
 */
class ConfusingNumber {
    fun confusingNumber(n: Int): Boolean {
        var num = n
        var rotated = 0
        while (num > 0) {
            val digit = num % 10
            num /= 10
            val rotatedDigit = when (digit) {
                0 -> 0
                1 -> 1
                6 -> 9
                8 -> 8
                9 -> 6
                else -> return false
            }
            rotated = rotated * 10 + rotatedDigit
        }
        return n != rotated
    }

}