package blind75.heap

import java.util.*

/**
 * 2542. Maximum Subsequence Score
 * Time: O( n * log(n)
 * Space: O(n)
 */
class MaximumSubsequenceScore {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val n = nums1.size
        val pairs = Array<Pair<Int, Int>>(n) { i ->
            Pair(nums1[i], nums2[i])
        }
        pairs.sortByDescending { it.second }
        val minHeap = PriorityQueue<Int>()
        var sum = 0L
        var max = 0L
        for (pair in pairs) {
            val curNums1 = pair.first
            val curNums2 = pair.second
            minHeap.add(curNums1)
            sum += curNums1
            if (minHeap.size > k) {
                sum -= minHeap.poll()
            }
            if (minHeap.size == k) {
                max = maxOf(max, sum * curNums2)
            }
        }
        return max
    }
}