package top150.array

/**
 * 14. Longest Common Prefix
 * Time: O(n * m)
 * Space: O(1)
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var n = Int.MAX_VALUE
        for (string in strs) {
            n = minOf(n, string.length)
        }
        for (i in 0 until n) {
            val char = strs[0][i]
            for (string in strs) {
                if (string[i] != char)
                    return string.substring(0, i)
            }
        }
        return strs[0].substring(0, n)
    }
}