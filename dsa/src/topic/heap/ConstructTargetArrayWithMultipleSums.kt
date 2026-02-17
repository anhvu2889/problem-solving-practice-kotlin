package topic.heap

import java.util.*

/**
 * 1354. Construct Target Array With Multiple Sums
 * Time: O(nlog(n))
 * Space: O(n)
 */
class ConstructTargetArrayWithMultipleSums {
    fun isPossible(target: IntArray): Boolean {
        val maxHeap = PriorityQueue<Long>(compareByDescending { it })
        var totalSum = 0L
        for (num in target) {
            totalSum += num
            maxHeap.add(num.toLong())
        }
        while (true) {
            val max = maxHeap.poll()
            val otherSum = totalSum - max
            if (max == 1L || otherSum == 1L) {
                return true
            }
            if (otherSum >= max || otherSum <= 0) {
                return false
            }
            val prev = max % otherSum
            if (prev == 0L) {
                return false
            }
            maxHeap.add(prev)
            totalSum = otherSum + prev
        }
    }
}