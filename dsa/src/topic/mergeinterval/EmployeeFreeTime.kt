package topic.mergeinterval

import java.util.*

/**
 * 759. Employee Free Time
 * Time: O(n * log(k))
 * Space: O(k)
 */
class EmployeeFreeTime {
    class Interval {
        var start: Int = 0
        var end: Int = 0

        constructor(_start: Int, _end: Int) {
            start = _start
            end = _end
        }
    }

    data class Node(val interval: Interval, val employeeIndex: Int, val intervalIndex: Int)

    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
        val result = ArrayList<Interval>()
        val minHeap = PriorityQueue<Node>() { a, b -> a.interval.start - b.interval.start }
        for (i in schedule.indices) {
            minHeap.add(Node(schedule[i][0], i, 0))
        }
        var end = minHeap.peek().interval.end
        while (minHeap.isNotEmpty()) {
            val minNode = minHeap.poll()
            val employeeIndex = minNode.employeeIndex
            if (minNode.interval.start > end) {
                result.add(Interval(end, minNode.interval.start))
            }
            end = maxOf(end, minNode.interval.end)
            if (minNode.intervalIndex < schedule[employeeIndex].size - 1) {
                val nextIntervalIndex = minNode.intervalIndex + 1
                minHeap.add(Node(schedule[employeeIndex][nextIntervalIndex], employeeIndex, nextIntervalIndex))
            }
        }
        return result
    }
}