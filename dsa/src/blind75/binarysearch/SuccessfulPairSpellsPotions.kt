package blind75.binarysearch

/**
 * 2300. Successful Pairs of Spells and Potions
 * Time: O((n + m) * log(m)
 * Space: O(1)
 */
class SuccessfulPairSpellsPotions {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val n = spells.size
        val m = potions.size
        val result = IntArray(n)
        potions.sort()
        for (i in spells.indices) {
            val spell = spells[i]
            var left = 0
            var right = m - 1
            var firstValid = m
            while( left <= right) {
                val mid = left + (right - left) / 2
                if (potions[mid].toLong() * spell >= success) {
                    firstValid = mid
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            result[i] = m - firstValid
        }
        return result
    }
}