package topic.topkelement

import java.util.*

/**
 * 1985. Find the Kth Largest Integer in the Array
 * Time: O(nlog(k))
 * Space: O(1)
 */
class FindKthLargestIntegerInArray {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        val minHeap = PriorityQueue<String>() { a, b -> compareIntString(a, b) }
        var i = 0
        for (num in nums) {
            minHeap.add(num)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        return minHeap.peek()
    }

    private fun compareIntString(a: String, b: String): Int {
        if (a.length != b.length) {
            return a.length - b.length
        } else {
            return a.compareTo(b)
        }
    }
}