package topic.slidingwindow

/**
 * 2271. Maximum White Tiles Covered by a Carpet
 * Time: O(n)
 * Space: O(n)
 */
class MaximumWhiteTilesCoveredCarpet {
    fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {
        tiles.sortBy { it[0] }
        val prefix = buildPrefix(tiles)
        return maxCover(tiles, prefix, carpetLen)
    }

    private fun buildPrefix(tiles: Array<IntArray>): IntArray {
        val n = tiles.size
        val prefix = IntArray(n + 1) //White cells in first i tiles
        for (i in 0 until n) {
            val tile = tiles[i]
            val start = tile[0]
            val end = tile[1]
            val len = end - start + 1
            prefix[i + 1] = prefix[i] + len
        }
        return prefix
    }

    private fun maxCover(tiles: Array<IntArray>, prefix: IntArray, carpetLen: Int): Int {
        val n = tiles.size
        var max = 0
        var last = 0
        for (first in 0 until n) {
            val end = tiles[first][0] + carpetLen - 1
            while (last < n - 1 && tiles[last + 1][0] <= end) {
                last++
            }
            val fullCover = prefix[last] - prefix[first]
            val lastStart = tiles[last][0]
            val lastEnd = tiles[last][1]
            val partialLast = minOf(lastEnd, end) - lastStart + 1
            max = maxOf(max, fullCover + partialLast)
        }
        return max
    }
}