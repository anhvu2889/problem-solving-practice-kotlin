package topic.dp

/**
 * 3699. Number of ZigZag Arrays I
 * Time: O(n)
 * Space: O(n)
 */
class NumberZigZagArrayI {
    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val MOD = 1_000_000_007L
        val m = r - l + 1
        var dpUp = LongArray(m)
        var dpDown = LongArray(m)
        /**
         *  l -> r
         *  0 -> m - 1
         */
        for (i in 0 until m) {
            dpUp[i] = i.toLong()
            dpDown[i] = (m - 1 - i).toLong()
        }
        repeat(n - 2) {
            val newDpUp = LongArray(m)
            val newDpDown = LongArray(m)
            for (i in 1 until m) {
                newDpUp[i] = (newDpUp[i - 1] + dpDown[i - 1]) % MOD
            }
            for (i in m - 2 downTo 0) {
                newDpDown[i] = (newDpDown[i + 1] + dpUp[i + 1]) % MOD
            }
            dpUp = newDpUp
            dpDown = newDpDown
        }
        var ans = 0L
        for (i in 0 until m) {
            ans = (ans + dpUp[i] + dpDown[i]) % MOD
        }
        return ans.toInt()
    }
}