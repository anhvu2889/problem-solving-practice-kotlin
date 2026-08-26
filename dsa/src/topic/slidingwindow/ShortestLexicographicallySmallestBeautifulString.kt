package topic.slidingwindow

/**
 * 2904. Shortest and Lexicographically Smallest Beautiful String
 * Time: O(n ^ 2)
 * Space: O(n)
 */
class ShortestLexicographicallySmallestBeautifulString {
    fun shortestBeautifulSubstring(s: String, k: Int): String {
        var l = 0
        var ones = 0
        var ans = ""
        for (r in s.indices) {
            if (s[r] == '1') {
                ones++
            }
            while (ones > k || (ones == k && s[l] == '0')) {
                if (s[l] == '1') {
                    ones--
                }
                l++
            }
            if (ones == k && s[r] == '1') {
                val candidate = s.substring(l, r + 1)
                if (isValidSmaller(ans, candidate)) {
                    ans = candidate
                }
            }
        }
        return ans
    }

    private fun isValidSmaller(ans: String, candidate: String): Boolean {
        if (ans.isEmpty()) {
            return true
        }
        if (candidate.length < ans.length) {
            return true
        }
        if (candidate.length == ans.length && candidate < ans) {
            return true
        }
        return false
    }
}