package topic.slidingwindow

/**
 * 2107. Number of Unique Flavors After Sharing K Candies
 * Time: O(n)
 * Space: O(n)
 */
class NumberUniqueFlavorsAfterSharingKCandies {
    fun shareCandies(candies: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        var max = 0
        val n = candies.size
        for (i in 0 until n) {
            val flavor = candies[i]
            val count = map.getOrDefault(flavor, 0)
            map[flavor] = count + 1
        }
        for (i in candies.indices) {
            val shared = candies[i]
            val count = map.getOrDefault(candies[i], 0) - 1
            if (count <= 0) {
                map.remove(shared)
            } else {
                map[shared] = count
            }
            if (i >= k) {
                val remain = candies[i - k]
                map[remain] = (map[remain] ?: 0) + 1
            }
            if (i >= k - 1) {
                max = maxOf(max, map.keys.size)
            }
        }
        return max
    }
}