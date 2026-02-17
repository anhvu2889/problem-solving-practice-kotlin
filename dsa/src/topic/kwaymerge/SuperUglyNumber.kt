package topic.kwaymerge

import java.util.*

/**
 * 313. Super Ugly Number
 * Time: O(nlog(k))
 * Space: O(n + k)
 */
class SuperUglyNumber {
    data class UNumber(val prime: Int, val index: Int, val uglyValue: Long)

    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        if (n == 1) return 1
        var uglyNumbers = mutableListOf(1)
        val minHeap = PriorityQueue<UNumber>(compareBy { it.uglyValue })
        for (prime in primes) {
            minHeap.add(UNumber(prime, 0, prime.toLong()))
        }
        while (uglyNumbers.size < n) {
            val min = minHeap.poll()
            if (min.uglyValue > uglyNumbers.last()) {
                uglyNumbers.add(min.uglyValue.toInt())
            }
            val nextUglyValue = min.prime.toLong() * uglyNumbers[min.index + 1]
            minHeap.add(UNumber(min.prime, min.index + 1, nextUglyValue))
        }
        return uglyNumbers[n - 1]
    }
}