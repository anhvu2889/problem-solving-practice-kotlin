package blind75.heap

import java.util.*

/**
 * 2336. Smallest Number in Infinite Set
 * Time: O(log(n))
 * Space:O(n)
 */
class SmallestNumberInfiniteSet {
    private val minHeap = PriorityQueue<Int>()
    private val inHeapSet = HashSet<Int>()
    private var nextMin = 1

    fun popSmallest(): Int {
        if (minHeap.isEmpty()) {
            val min = nextMin
            nextMin++
            return min
        } else {
            inHeapSet.remove(minHeap.peek())
            return minHeap.poll()
        }
    }

    fun addBack(num: Int) {
        if (num >= nextMin || inHeapSet.contains(num))
            return
        minHeap.add(num)
        inHeapSet.add(num)
    }

}