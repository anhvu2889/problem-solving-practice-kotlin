package blind75.queue

/**
 * 933. Number of Recent Calls
 * Time: O(n)
 * Space: O(n)
 */
class NumberRecentCalls {
    val queue = ArrayDeque<Int>()
    fun ping(t: Int): Int {
        queue.add(t)
        while (queue.isNotEmpty() && queue.first() < t - 3000) {
            queue.removeFirst()
        }
        return queue.size
    }
}