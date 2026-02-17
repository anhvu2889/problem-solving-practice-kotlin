package topic.mergeinterval

/**
 * 1094. Car Pooling
 * Time: O(n)
 * Space: O(1)
 */
class CarPooling {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        var track = IntArray(1001)
        for (trip in trips) {
            track[trip[1]] += trip[0]
            track[trip[2]] -= trip[0]
        }
        var ocupied = 0
        for (change in track) {
            ocupied += change
            if (ocupied > capacity) {
                return false
            }
        }
        return true
    }
}