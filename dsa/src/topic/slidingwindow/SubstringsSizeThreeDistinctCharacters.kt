package topic.slidingwindow

/**
 * 1876. Substrings of Size Three with Distinct Characters
 * Time: O(n)
 * Space: O(1)
 */
class SubstringsSizeThreeDistinctCharacters {
    fun countGoodSubstrings(s: String): Int {
        var count = 0
        for (i in 0 until s.length - 2) {
            if (s[i] == s[i + 1] || s[i + 1] == s[i + 2] || s[i] == s[i + 2]) {
                continue
            }
            count ++
        }
        return count
    }
}