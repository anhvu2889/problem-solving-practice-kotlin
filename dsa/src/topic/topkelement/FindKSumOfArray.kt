package topic.topkelement

import java.util.*
import kotlin.math.abs

/**
 * 2386. Find the K-Sum of an Array
 * Time:
 * Space: 
 */
class FindKSumOfArray {
    fun kSum(nums: IntArray, k: Int): Long {
        var base = 0L
        val a = LongArray(nums.size)
        for (i in nums.indices) {
            val v = nums[i].toLong()
            if (v > 0) base += v
            a[i] = abs(v)
        }
        a.sort()
        if (k == 1) return base
        val pq = PriorityQueue(compareBy<Pair<Long, Int>> { it.first }.thenBy { it.second })
        if (a.isNotEmpty()) pq.add(Pair(a[0], 0))
        var t = k - 1
        var last = 0L
        while (t > 0 && pq.isNotEmpty()) {
            val (s, i) = pq.poll()
            last = s
            if (i + 1 < a.size) {
                pq.add(Pair(s + a[i + 1], i + 1))
                pq.add(Pair(s - a[i] + a[i + 1], i + 1))
            }
            t--
        }
        return base - last
    }
}