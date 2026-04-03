package blind75.prefixsum

/**
 * 1732. Find the Highest Altitude
 * Time: O(n)
 * Space: O(1)
 */
class FindHighestAltitude {
    fun largestAltitude(gain: IntArray): Int {
        var alt = IntArray(gain.size + 1)
        alt[0] = 0
        var max = 0
        for (i in 1..<alt.size) {
            alt[i] = alt[i - 1] + gain[i - 1]
            max = maxOf(max, alt[i])
        }
        return max
    }
}