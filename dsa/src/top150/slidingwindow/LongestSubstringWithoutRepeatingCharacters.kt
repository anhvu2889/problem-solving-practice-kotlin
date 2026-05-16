package top150.slidingwindow

/**
 * 3. Longest Substring Without Repeating Characters
 * Time: O(n)
 * Space: O(1)
 */
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastSeen = IntArray(128) { -1 }
        var l = 0
        var max = 0
        for (r in s.indices) {
            val code = s[r].code
            l = maxOf(l, lastSeen[code] + 1)
            lastSeen[code] = r
            max = maxOf(r - l + 1, max)
        }
        return max
    }
}