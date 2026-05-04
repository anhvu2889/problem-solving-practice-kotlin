package top150.array

/**
 * 28. Find the Index of the First Occurrence in a String
 * Time: O(n + m)
 * Space: O(m)
 */
class FindIndexFirstOccurrenceInString {
    fun strStr(haystack: String, needle: String): Int {
        val n = haystack.length
        val m = needle.length
        if (n < m)
            return -1
        val lps = lps(needle)
        var i = 0
        var j = 0
        while (i < n) {
            if (haystack[i] == needle[j]) {
                i++
                j++
                if (j == m)
                    return i - m
            } else {
                if (j > 0) {
                    j = lps[j - 1]
                } else {
                    i++
                }
            }
        }
        return -1
    }

    fun lps(s: String): IntArray {
        val n = s.length
        val lps = IntArray(n)
        var i = 1
        var len = 0
        while (i < n) {
            if (s[i] == s[len]) {
                len++
                lps[i] = len
                i++
            } else {
                if (len > 0) {
                    len = lps[len - 1]
                } else {
                    lps[i] = 0
                    i++
                }

            }
        }
        return lps
    }
}