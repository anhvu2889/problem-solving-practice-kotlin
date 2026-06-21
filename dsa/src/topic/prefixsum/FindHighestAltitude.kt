package topic.prefixsum

/**
 * 1732. Find the Highest Altitude
 * Time: O(n)
 * Space: O(1)
 */
class FindHighestAltitude {
    fun largestAltitude(gain: IntArray): Int {
        val n = gain.size
        var altitue = 0
        var max = 0
        for (i in gain.indices) {
            altitue += gain[i]
            max = maxOf(altitue, max)
        }
        return max
    }
}