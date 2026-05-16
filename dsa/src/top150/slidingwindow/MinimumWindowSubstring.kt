package top150.slidingwindow

/**
 * 76. Minimum Window Substring
 * Time: O(m + n)
 * Space: O(1)
 */
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length)
            return ""
        val needCount = t.length
        val needFreq = IntArray(128)
        for (c in t) {
            needFreq[c.code]++
        }
        var l = 0
        val curFreq = IntArray(128)
        var curCount = 0
        var min = Int.MAX_VALUE
        var start = 0
        for (r in 0 until s.length) {
            val c = s[r].code
            curFreq[c]++
            if (curFreq[c] <= needFreq[c]) {
                curCount++
            }
            while (curCount == needCount) {
                val first = s[l].code
                if (curFreq[first] > needFreq[first] || needFreq[first] == 0) {
                    curFreq[first]--
                    l++
                } else {
                    break
                }
            }
            if (curCount == needCount) {
                val len = r - l + 1
                if (len < min) {
                    min = len
                    start = l
                }
                val first = s[l].code
                curFreq[first]--
                curCount--
                l++
            }
        }
        return if (min == Int.MAX_VALUE) "" else s.substring(start, start + min)
    }
}