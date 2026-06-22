package top150.binarysearch

/**
 * 74. Search a 2D Matrix
 * Time: O(log(m * n))
 * Space: O(1)
 */
class Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        var l = 0
        var r = m * n - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            val row = mid / n
            val col = mid % n
            val cur = matrix[row][col]
            if (cur == target)
                return true
            else if (cur > target)
                r = mid - 1
            else
                l = mid + 1
        }
        return false
    }
}