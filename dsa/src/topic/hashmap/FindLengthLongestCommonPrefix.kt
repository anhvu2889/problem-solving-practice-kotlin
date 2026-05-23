package topic.hashmap

/**
 * 3043. Find the Length of the Longest Common Prefix
 * Time: O(m + n)
 * Space: O(m + n)
 */
class FindLengthLongestCommonPrefix {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        var ans = 0
        val set = HashSet<String>()
        for (num in arr1) {
            val sb = StringBuilder()
            val s = num.toString()
            for (c in s) {
                sb.append(c)
                set.add(sb.toString())
            }
        }
        for (num in arr2) {
            val sb = StringBuilder()
            val s = num.toString()
            for (c in s) {
                sb.append(c)
                if (set.contains(sb.toString()))
                    ans = maxOf(ans, sb.length)
            }
        }
        return ans
    }
}