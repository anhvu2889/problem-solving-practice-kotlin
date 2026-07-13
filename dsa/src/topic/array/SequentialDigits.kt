package topic.array

/**
 * 1291. Sequential Digits
 * Time: O(1)
 * Space: O(1)
 */
class SequentialDigits {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val ans = mutableListOf<Int>()
        val DIGITS = "123456789"
        val minLen = minOf(9, low.toString().length)
        val maxLen = minOf(9, high.toString().length)
        for (len in minLen..maxLen) {
            val maxStart = 9 - len
            for (start in 0..maxStart) {
                val candidate = DIGITS.substring(start, start + len).toInt()
                if (candidate in low..high)
                    ans.add(candidate)
            }
        }
        return ans
    }
}