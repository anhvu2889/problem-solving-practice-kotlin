package topic.twopointer

class ValidPalindromeIII {
    fun isValidPalindrome(s: String, k: Int): Boolean {
        return isValidPalindrome(s, 0, s.length - 1, k)
    }

    private fun isValidPalindrome(s: String, start: Int, end: Int, budget: Int): Boolean {
        var l = start
        var r = end
        while (l < r) {
            if (s[l] != s[r]) {
                return if (budget > 0) {
                    isValidPalindrome(s, l + 1, end, budget - 1) || isValidPalindrome(s, l, end - 1, budget - 1)
                } else {
                    false
                }
            }
            l++
            r--
        }
        return true
    }
}