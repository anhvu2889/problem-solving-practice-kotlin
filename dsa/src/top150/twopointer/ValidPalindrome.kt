package top150.twopointer

/**
 * 125. Valid Palindrome
 * Time: O(n)
 * Space: O(1)
 */
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            while (l < r && !s[l].isLetterOrDigit())
                l++
            while (l < r && !s[r].isLetterOrDigit())
                r--
            if (s[l].lowercaseChar() == s[r].lowercaseChar()) {
                l++
                r--
            } else {
                return false
            }
        }
        return true
    }
}