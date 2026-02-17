package topic.heap

import java.util.PriorityQueue

/**
 * 1167. Minimum Cost to Connect Sticks
 * Time: O(nlog(n)
 * Space: O(n)
 */
class MinimumCostConnectStick {
    fun connectSticks(sticks: IntArray): Int {
        var total = 0
        var minHeap = PriorityQueue<Int>()
        for (stick in sticks) {
            minHeap.add(stick)
        }
        while (minHeap.size > 1) {
            val sum = minHeap.poll() + minHeap.poll()
            total += sum
            minHeap.add(sum)
        }
        return total
    }
}