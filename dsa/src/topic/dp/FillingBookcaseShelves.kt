package topic.dp

/**
 * 1105. Filling Bookcase Shelves
 * Time: O(n ^ 2)
 * Space: O(n)
 */
class FillingBookcaseShelves {
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val n = books.size
        val minHeight = IntArray(n + 1)  // minHeight[count] = min total height with the first count books placed
        for (count in 1..n) {
            minHeight[count] = minHeightForFirst(books, count, shelfWidth, minHeight)
        }
        return minHeight[n]
    }

    private fun minHeightForFirst(books: Array<IntArray>, count: Int, shelfWidth: Int, minHeight: IntArray): Int {
        var lastShelfWidth = 0
        var maxLastShelfHeight = 0
        var bestTotal = Int.MAX_VALUE
        var i = count - 1  // i = first book on the last shelf, shelf = books i..count-1
        while (i >= 0) {
            lastShelfWidth += books[i][0]
            if (lastShelfWidth > shelfWidth) {
                break
            }
            maxLastShelfHeight = maxOf(maxLastShelfHeight, books[i][1])
            bestTotal = minOf(bestTotal, minHeight[i] + maxLastShelfHeight)
            i--
        }
        return bestTotal
    }
}