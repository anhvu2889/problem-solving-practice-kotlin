package topic.dp

/**
 * 788. Rotated Digits
 * Time: O(n)
 * Space: O(n)
 */
class RotatedDigits {
    fun rotatedDigits(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        var count = 0
        for (i in 1..n) {
            val prefix = i / 10
            val lastDigit = i % 10
            if (lastDigit == 3 || lastDigit == 4 || lastDigit == 7 || dp[prefix] == 0) {
                dp[i] = 0
            } else if (dp[prefix] == 2 || lastDigit == 2 || lastDigit == 5 || lastDigit == 6 || lastDigit == 9) {
                dp[i] = 2
                count++
            } else {
                dp[i] = 1
            }
        }
        return count
    }
}