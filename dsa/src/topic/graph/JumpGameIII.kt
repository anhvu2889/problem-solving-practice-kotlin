package topic.graph

/**
 * 1306. Jump Game III
 * Time: O(n)
 * Space: O(n)
 */
class JumpGameIII {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val n = arr.size
        val visited = BooleanArray(n)
        val queue = ArrayDeque<Int>()
        val dirs = intArrayOf(-1, 1)
        queue.addFirst(start)
        visited[start] = true
        while (queue.isNotEmpty()) {
            val cur = queue.removeLast()
            if (arr[cur] == 0)
                return true
            for (dir in dirs) {
                val adj = cur + arr[cur] * dir
                if (adj in 0 until n && !visited[adj]) {
                    queue.addFirst(adj)
                    visited[adj] = true
                }
            }
        }
        return false
    }

}