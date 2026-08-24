package topic.math

/**
 * 1927. Sum Game
 * Time: O(n)
 * Space: O(1)
 */
class SumGame {
    fun sumGame(num: String): Boolean {
        var q1 = 0
        var q2 = 0
        var diff = 0
        val half = num.length / 2
        for (i in num.indices) {
            val c = num[i]
            if (i < half) {
                if (c == '?') {
                    q1++
                } else {
                    diff += c - '0'
                }
            } else {
                if (c == '?') {
                    q2++
                } else {
                    diff -= c - '0'
                }
            }
        }
        if ((q1 + q2) % 2 == 1) {
            return true
        }
        return 2 * diff != 9 * (q2 - q1)
    }
}