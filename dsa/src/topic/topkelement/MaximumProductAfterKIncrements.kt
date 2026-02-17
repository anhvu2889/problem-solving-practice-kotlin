package topic.topkelement

import java.util.*

/**
 * 2233. Maximum Product After K Increments
 * Time: O(nlog(n))
 * Space: O(n)
 */
class MaximumProductAfterKIncrements {
    fun maximumProduct(nums: IntArray, k: Int): Int {
        val mod = 1_000_000_007L
        var prod = 1L
        val minHeap = PriorityQueue<Int>()
        for (num in nums) {
            minHeap.add(num)
        }
        repeat(k) {
            val min = minHeap.poll()
            minHeap.add(min + 1)
        }
        while (minHeap.isNotEmpty()) {
            prod = (prod * minHeap.poll().toLong()) % mod
        }
        return (prod % mod).toInt()
    }
}