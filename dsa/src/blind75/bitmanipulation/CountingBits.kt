package blind75.bitmanipulation

/**
 * 338. Counting Bits
 * Time: O(n)
 * Space: O(n)
 */
class CountingBits {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)
        for (i in 1..n) {
            result[i] = result[i shr 1] + (i and 1)
        }
        return result
    }
}