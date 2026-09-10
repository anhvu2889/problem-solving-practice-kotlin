package topic.math

import kotlin.math.pow

class CountCommasRangeII {
    fun countCommas(n: Long): Long {
        val digits = countDigits(n)
        return countCommas(n, digits)
    }

    private fun countDigits(n: Long): Int {
        var num = n
        var digits = 0
        while (num > 0) {
            digits++
            num /= 10
        }
        return digits
    }

    private fun countCommas(n: Long, digits: Int): Long {
        var ans = 0L
        var i = 0
        while (i * 3 < digits) {
            val countNumbers = minOf(10.0.pow(3 * (i + 1)), n.toDouble() + 1) - 10.0.pow(i * 3)
            val countCommas = countNumbers.toLong() * i
            ans += countCommas
            i++
        }
        return ans
    }
}