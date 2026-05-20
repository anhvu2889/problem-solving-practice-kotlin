package topic.array

/**
 * 2657. Find the Prefix Common Array of Two Arrays
 * Time: O(n)
 * Space: O(n)
 */
class FindPrefixCommonArrayTwoArrays {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        val ans = IntArray(n)
        var common = 0
        val freq = IntArray(n + 1)
        for (i in 0 until n) {
            freq[A[i]]++
            if (freq[A[i]] == 2)
                common++
            freq[B[i]]++
            if (freq[B[i]] == 2)
                common++
            ans[i] = common
        }
        return ans
    }
}