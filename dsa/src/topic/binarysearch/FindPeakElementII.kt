package topic.binarysearch

/**
 * 1901. Find a Peak Element II
 * Time: O(n * log(m))
 * Space: O(1)
 */
class FindPeakElementII {
    fun findPeakGrid(mat: Array<IntArray>): IntArray {
        var lowRow = 0
        var hiRow = mat.size - 1
        while (lowRow < hiRow) {
            val midRow = lowRow + (hiRow - lowRow) / 2
            val colMaxInRow = findColMaxInRow(mat[midRow])
            if (mat[midRow][colMaxInRow] > mat[midRow + 1][colMaxInRow]) {
                hiRow = midRow
            } else {
                lowRow = midRow + 1
            }
        }
        val col = findColMaxInRow(mat[lowRow])
        return intArrayOf(lowRow, col)
    }

    private fun findColMaxInRow(row: IntArray): Int {
        var ans = 0
        var max = row[0]
        for (i in row.indices) {
            if (row[i] > max) {
                max = row[i]
                ans = i
            }
        }
        return ans
    }
}