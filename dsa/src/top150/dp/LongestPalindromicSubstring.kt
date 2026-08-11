package top150.dp

/**
 * 5. Longest Palindromic Substring
 * Time: O(n ^ 2)
 * Space: O(1)
 */
class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var start = 0
        var maxLength = 1
        for (i in s.indices) {
            val odd = maxLength(s, i, i)
            val even = maxLength(s, i, i + 1)
            val max = maxOf(odd, even)
            if (max > maxLength) {
                maxLength = max
                start = i - (max - 1) / 2
            }
        }
        return s.substring(start, start + maxLength)
    }

    private fun maxLength(s: String, start: Int, end: Int): Int {
        var l = start
        var r = end
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }
}