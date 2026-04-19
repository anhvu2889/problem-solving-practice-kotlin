package blind75.heap

import java.util.*

/**
 * 2462. Total Cost to Hire K Workers
 * Time: O((k + candidate) * log(candidate))
 * Space: O(candidate)
 */
class TotalCostHireKWorkers {
    data class Worker(val cost: Int, val index: Int)

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val n = costs.size
        var sum = 0L
        val minHeap = PriorityQueue<Worker>() { a, b ->
            if (a.cost != b.cost)
                a.cost - b.cost
            else
                a.index - b.index
        }
        var left = 0
        var right = n - 1
        repeat(candidates) {
            minHeap.add(Worker(costs[left], left))
            left++
        }
        repeat(candidates) {
            if (right >= left) {
                minHeap.add(Worker(costs[right], right))
                right--
            }
        }
        repeat(k) {
            val min = minHeap.poll()
            sum += min.cost.toLong()
            if (left <= right) {
                if (min.index < left) {
                    minHeap.add(Worker(costs[left], left))
                    left++
                } else {
                    minHeap.add(Worker(costs[right], right))
                    right--
                }
            }
        }
        return sum
    }
}