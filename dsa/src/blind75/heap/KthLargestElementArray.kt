package blind75.heap

import java.util.PriorityQueue

/**
 * 215. Kth Largest Element in an Array
 * Time: O(n * log(k))
 * Space: O(k)
 */
class KthLargestElementArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()
        for (i in 0 until k) {
            minHeap.add(nums[i])
        }
        for (i in k until nums.size) {
            val min = minHeap.peek()
            if (nums[i] <= min)
                continue
            minHeap.poll()
            minHeap.add(nums[i])
        }
        return minHeap.peek()
    }
}