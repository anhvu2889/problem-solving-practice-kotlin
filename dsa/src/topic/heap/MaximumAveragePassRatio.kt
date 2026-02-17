package topic.heap

import java.util.*

/**
 * 1792. Maximum Average Pass Ratio
 * Time: O(nlog(n))
 * Space: O(n)
 */
class MaximumAveragePassRatio {
    class Ratio(var pass: Int, var total: Int) {
        var ratio = pass.toDouble()/total
        var gain = (pass+1).toDouble()/(total+1)-ratio

        fun addOne(): Ratio {
            pass++; total++
            ratio = pass.toDouble()/total
            gain = (pass+1).toDouble()/(total+1)-ratio
            return this
        }
    }
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val pq = PriorityQueue<Ratio>(compareByDescending { it.gain })
        classes.forEach {
            pq.add(Ratio(it[0], it[1]))
        }
        repeat(extraStudents) {
            pq.add(pq.remove().addOne())
        }
        return pq.sumOf { it.ratio } /classes.size
    }
}