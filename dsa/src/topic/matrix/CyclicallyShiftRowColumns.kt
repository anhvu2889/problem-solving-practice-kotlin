package topic.matrix

/**
 * 4052. Cyclically Shift Rows and Columns
 * Time: O(n ^ 2)
 * Space: O(1)
 */
class CyclicallyShiftRowColumns {
    fun cyclicShift(n: Int, grid: Array<IntArray>, rowShift: IntArray, colShift: IntArray): Array<IntArray> {
        val ans = Array(n){IntArray(n)}
        for (r in rowShift.indices) {
            val rs = rowShift[r]
            for (i in 0 until n) {
                ans[r][i] = grid[r][(i + rs) % n]
            }
        }

        for (c in colShift.indices) {
            val cs = colShift[c]
            for (i in 0 until n) {
                ans[i][c] = grid[(i + cs) % n][c]
            }
        }
        return ans
    }
}