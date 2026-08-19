package topic.slidingwindow

/**
 * 3090. Maximum Length Substring With Two Occurrences
 * Time: O(n)
 * Space: O(1)
 */
class MaximumLengthSubstringWithTwoOccurrences {
    fun maximumLengthSubstring(s: String): Int {
        val k = 2
        var ans = 0
        if (s.length <= k)
            return s.length
        val freqMap = HashMap<Char, Int>()
        var l = 0
        for (r in s.indices) {
            val rightChar = s[r]
            freqMap[rightChar] = freqMap.getOrDefault(rightChar, 0) + 1
            while (freqMap[rightChar]!! > k) {
                val leftChar = s[l]
                freqMap[leftChar] = freqMap.getOrDefault(leftChar, 0) - 1
                l++
            }
            ans = maxOf(ans, r - l + 1)
        }
        return ans
    }
}