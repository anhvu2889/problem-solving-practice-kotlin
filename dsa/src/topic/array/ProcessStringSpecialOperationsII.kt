package topic.array

/**
 * 3614. Process String with Special Operations II
 * Time: O(n)
 * Space: O(n)
 */
class ProcessStringSpecialOperationsII {
    fun processStr(s: String, k: Long): Char {
        val lengths = LongArray(s.length + 1)
        lengths[0] = 0L
        val MAX = 1_000_000_000_000_000_000L
        for (i in s.indices) {
            when (s[i]) {
                '#' -> lengths[i + 1] = minOf(lengths[i] * 2, MAX)
                '%' -> lengths[i + 1] = lengths[i]
                '*' -> lengths[i + 1] = maxOf(lengths[i] - 1, 0L)
                else -> lengths[i + 1] = minOf(lengths[i] + 1, MAX)
            }
        }
        var m = k
        if (m >= lengths[s.length])
            return '.'
        for (i in s.length - 1 downTo 0) {
            when (s[i]) {
                '#' -> if (m >= lengths[i]) m -= lengths[i]
                '%' -> m = lengths[i + 1] - 1 - m
                '*' -> {}
                else -> if (m == lengths[i]) return s[i]
            }
        }
        return '.'
    }
}