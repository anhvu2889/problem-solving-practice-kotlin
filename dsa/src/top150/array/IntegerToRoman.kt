package top150.array

import java.lang.StringBuilder

/**
 * 12. Integer to Roman
 * Time: O(1)
 * Space: O(1)
 */
class IntegerToRoman {
    fun intToRoman(num: Int): String {
        val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var remainder = num
        val sb = StringBuilder()
        for (i in values.indices) {
            while (remainder >= values[i]) {
                sb.append(symbols[i])
                remainder -= values[i]
            }
        }
        return sb.toString()
    }
}