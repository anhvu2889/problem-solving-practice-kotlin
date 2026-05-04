package top150.array

/**
 * 13. Roman to Integer
 * Time: O(n)
 * Space: O(1)
 */
class RomanToInteger {
    fun romanToInt(s: String): Int {
        var sum = charToInt(s[0])
        for (i in 1 until s.length) {
            if (charToInt(s[i - 1]) < charToInt(s[i]))
                sum += charToInt(s[i]) - 2 * charToInt(s[i - 1])
            else
                sum += charToInt(s[i])
        }
        return sum

    }

    private fun charToInt(char: Char): Int {
        return when (char) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }
}