package topic.binarysearch

/**
 * 1891. Cutting Ribbons
 * Time: O(nlog(n))
 * Space: O(1)
 */
class CuttingRibbons {
    fun maxLength(ribbons: IntArray, k: Int): Int {
        var total = 0L
        var max = 0
        for (r in ribbons) {
            total += r
            max = maxOf(max, r)
        }
        if (total < k) {
            return 0
        }
        var l = 1
        var h = max + 1
        while (l < h) {
            val mid = l + (h - l) / 2
            if (canCut(ribbons, mid, k)) {
                l = mid + 1
            } else {
                h = mid
            }
        }
        return l - 1

    }

    private fun canCut(ribbons: IntArray, x: Int, k: Int): Boolean {
        var count = 0
        for (r in ribbons) {
            count += r / x
            if (count >= k) {
                return true
            }
        }
        return false
    }
}