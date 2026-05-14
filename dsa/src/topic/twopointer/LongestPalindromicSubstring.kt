package topic.twopointer

/**
 * 5. Longest Palindromic Substring
 * Time: O(n^2)
 * Space: O(1)
 */
class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var maxLength = 1
        var start = 0
        val n = s.length
        for (i in 0 until n - 1) {
            val maxOddLength = maxLengthPalindrome(s, i, i)
            val maxEvenLength = maxLengthPalindrome(s, i, i + 1)
            val max = maxOf(maxEvenLength, maxOddLength)
            if (maxLength < max) {
                maxLength = max
                start = i - (maxLength - 1) / 2
            }
        }
        return s.substring(start, start + maxLength)
    }

    fun maxLengthPalindrome(s: String, start: Int, end: Int): Int {
        var max = 1
        var l = start
        var r = end
        while (l >= 0 && r <= s.length - 1 && s[l] == s[r]) {
            max = r - l + 1
            l--
            r++
        }
        return max
    }
}