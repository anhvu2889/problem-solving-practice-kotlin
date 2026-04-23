package blind75.binarysearch

/**
 * 875. Koko Eating Bananas
 * Time: O(n * log(n))
 * Space: O(1)
 */
class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var max = Int.MIN_VALUE
        for (pile in piles) {
            max = maxOf(pile, max)
        }
        var l = 1
        var r = max
        var ans = max
        while (l <= r) {
            val mid = l + (r - l) / 2
            var hours = 0L
            for (pile in piles) {
                hours += (pile + mid - 1L) / mid
                if (hours > h)
                    break
            }
            if (hours <= h) {
                ans = mid
                r = mid - 1
            } else {
                l = mid + 1
            }

        }
        return ans
    }
}