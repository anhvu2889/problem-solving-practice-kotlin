package topic.hashmap

/**
 * 3016. Minimum Number of Pushes to Type Word II
 * Time: O(n)
 * Space: O(1)
 */
class MinimumNumberPushTypeWordII {
    fun minimumPushes(word: String): Int {
        val freq = IntArray(26)
        for (c in word) {
            freq[c - 'a']++
        }
        freq.sortDescending()
        var total = 0
        for (i in freq.indices) {
            if (freq[i] == 0) break
            val pos = (i / 8) + 1
            total += freq[i] * pos
        }
        return total
    }
}