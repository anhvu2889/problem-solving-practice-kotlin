package topic.topkelement

import java.util.*

/**
 * 1383. Maximum Performance of a Team
 * Time: O(nlog(k))
 * Space: O(n)
 */
class MaximumPerformanceOfTeam {
    data class Engineer(val speed: Int, val efficiency: Int)

    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        var maxPerf = 0L
        val engineers = Array(n) { i -> Engineer(speed[i], efficiency[i]) }
        engineers.sortWith(compareByDescending<Engineer> { it.efficiency })
        val minHeap = PriorityQueue<Int>()
        var sumSpeed = 0L
        for (engineer in engineers) {
            minHeap.add(engineer.speed)
            sumSpeed += engineer.speed.toLong()
            if (minHeap.size > k) {
                sumSpeed -= minHeap.poll()
            }
            maxPerf = maxOf(maxPerf, sumSpeed * engineer.efficiency)
        }
        return (maxPerf % 1_000_000_007L).toInt()
    }
}