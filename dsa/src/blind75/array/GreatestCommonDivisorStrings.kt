package blind75.array

/**
 * 1071. Greatest Common Divisor of Strings
 * Time: O(n + m)
 * Space: O(1)
 */
class GreatestCommonDivisorStrings {
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1)
            return ""
        val length = gcd(str1.length, str2.length)
        return str1.substring(0, length)
    }

    fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = x % y
            x = y
            y = temp
        }
        return x
    }
}