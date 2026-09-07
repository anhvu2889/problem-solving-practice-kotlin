package topic.slidingwindow

/**
 * 438. Find All Anagrams in a String
 * Time: O(n + k)
 * Space: O(1)
 */
class FindAllAnagramInString {
    fun findAnagrams(s: String, p: String): List<Int> {
        val n = s.length
        val k = p.length
        val ans = mutableListOf<Int>()
        if (k > n) {
            return ans
        }
        val target = buildTarget(p)
        var mismatch = initMismatch(target)
        val freq = IntArray(26)
        for (r in s.indices) {
            mismatch += updateMismatch(target, freq, s[r], 1)
            if (r >= k) {
                mismatch += updateMismatch(target, freq, s[r - k], -1)
            }
            if (mismatch == 0) {
                ans.add(r - k + 1)
            }
        }
        return ans
    }

    private fun updateMismatch(target: IntArray, freq: IntArray, c: Char, delta: Int): Int {
        val code = c - 'a'
        val before = freq[code]
        freq[code] += delta
        if (before == target[code]) {
            return 1
        } else if (freq[code] == target[code]) {
            return -1
        } else {
            return 0
        }
    }

    private fun buildTarget(p: String): IntArray {
        val freq = IntArray(26)
        for (c in p) {
            freq[c - 'a']++
        }
        return freq
    }

    private fun initMismatch(freq: IntArray): Int {
        var count = 0
        for (f in freq) {
            if (f > 0) {
                count++
            }
        }
        return count
    }
}