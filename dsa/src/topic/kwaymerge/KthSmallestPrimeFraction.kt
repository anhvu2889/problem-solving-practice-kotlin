package topic.kwaymerge

import java.util.*

/**
 * 786. K-th Smallest Prime Fraction
 * Time: O(k * log(n))
 * Space: O(n)
 */
class KthSmallestPrimeFraction {
    data class Fraction(val numIndex: Int, val demIndex: Int, val frac: Double)

    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val minHeap = PriorityQueue<Fraction>(compareBy { it.frac })
        val n = arr.size
        for (i in 1..<n) {
            minHeap.add(Fraction(0, i, arr[0].toDouble() / arr[i]))
        }
        repeat(k - 1) {
            val min = minHeap.poll()
            if (min.numIndex + 1 < min.demIndex) {
                minHeap.add(Fraction(min.numIndex + 1, min.demIndex, arr[min.numIndex + 1].toDouble() / arr[min.demIndex]))
            }
        }
        val top = minHeap.peek()
        return intArrayOf(arr[top.numIndex], arr[top.demIndex])
    }
}