package topic.twopointer

/**
 * 680. Valid Palindrome II
 * Time: O(n)
 * Space: O(1)
 */
class ValidPalindromeII {
    fun validPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]) {
                return isValidPalindrome(s, l, r - 1) || isValidPalindrome(s, l + 1, r)
            }
            l++
            r--
        }
        return true
    }

    private fun isValidPalindrome(s: String, start: Int, end: Int): Boolean {
        var l = start
        var r = end
        while (l < r) {
            if (s[l] != s[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }
}