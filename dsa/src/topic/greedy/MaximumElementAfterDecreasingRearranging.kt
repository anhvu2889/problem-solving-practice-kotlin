package topic.greedy

/**
 * 1846. Maximum Element After Decreasing and Rearranging
 * Time: O(n)
 * Space: O(n)
 */
class MaximumElementAfterDecreasingRearranging {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        var max = 0
        val n = arr.size
        val freq = IntArray(n + 1)
        for (num in arr) {
            val value = minOf(n, num)
            freq[value]++
        }
        for (num in freq.indices) {
            max = minOf(max + freq[num], num)
        }
        return max
    }
}