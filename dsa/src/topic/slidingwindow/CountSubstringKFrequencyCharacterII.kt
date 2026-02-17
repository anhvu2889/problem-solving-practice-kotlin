package topic.slidingwindow

/**
 * 3329. Count Substrings With K-Frequency Characters II
 * Time: O(n)
 * Space: O(1)
 */
class CountSubstringKFrequencyCharacterII {
    fun numberOfSubstrings(s: String, k: Int): Long {
        if (k <= 0 || s.isEmpty()) return 0L

        val n = s.length
        val freq = IntArray(26)
        var maxFreq = 0
        var total = 0L
        var left = 0

        for (right in 0 until n) {
            val charIdx = s[right] - 'a'
            freq[charIdx]++
            maxFreq = maxOf(maxFreq, freq[charIdx])

            while (left <= right && maxFreq >= k) {
                total += (n - right).toLong()
                val leftCharIdx = s[left] - 'a'
                freq[leftCharIdx]--
                left++
                maxFreq = freq.max()
            }
        }
        return total
    }
}