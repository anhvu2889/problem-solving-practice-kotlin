package topic.slidingwindow

/**
 * 1358. Number of Substrings Containing All Three Characters
 * Time: O(n)
 * Space: O(1)
 */
class NumberSubstringsContainingAllThreeCharacters {
    fun numberOfSubstrings(s: String): Int {
        val n = s.length
        val freq = IntArray(3)
        var distinct = 0
        var l = 0
        var count = 0
        for (r in 0 until n) {
            val idx = s[r] - 'a'
            freq[idx]++
            if (freq[idx] == 1) {
                distinct++
            }
            while (distinct == 3) {
                val lIdx = s[l] - 'a'
                freq[lIdx]--
                if (freq[lIdx] == 0) {
                    distinct--
                }
                l++
            }
            count += l
        }
        return count
    }
}