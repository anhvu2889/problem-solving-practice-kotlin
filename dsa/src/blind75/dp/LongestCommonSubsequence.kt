package blind75.dp

/**
 * 1143. Longest Common Subsequence
 * Time: O(m * n)
 * Space: O(min(m, n))
 */
class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val longText = if (text1.length >= text2.length) text1 else text2
        val shortText = if (text1.length >= text2.length) text2 else text1
        val m = longText.length
        val n = shortText.length
        var prevRow = IntArray(n + 1)
        var curRow = IntArray(n + 1)
        for (row in 1..m) {
            for (col in 1..n) {
                if (longText[row - 1] == shortText[col - 1]) {
                    curRow[col] = 1 + prevRow[col - 1]
                } else {
                    curRow[col] = maxOf(prevRow[col], curRow[col - 1])
                }
            }
            val temp = prevRow
            prevRow = curRow
            curRow = temp
        }
        return prevRow[n]
    }

}