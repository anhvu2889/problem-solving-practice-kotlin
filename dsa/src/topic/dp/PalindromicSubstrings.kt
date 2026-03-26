package topic.dp

/**
 * 647. Palindromic Substrings
 * Time: O(n ^ 2)
 * Space: O(1)
 */
class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in s.indices) {
            count += expand(s, i, i)
            count += expand(s, i, i + 1)
        }
        return count
    }

    fun expand(s: String, left: Int, right: Int): Int {
        var count = 0
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            count++
            l--
            r++
        }
        return count
    }
}