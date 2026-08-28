package topic.graph

/**
 * 286. Walls and Gates
 * Time: O(m * n)
 * Space: O(m * n)
 */
class WallsAndGates {
    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val m = rooms.size
        val n = rooms[0].size
        val dr = listOf(0, 0, 1, -1)
        val dc = listOf(-1, 1, 0, 0)
        val queue = ArrayDeque<Pair<Int, Int>>()
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (rooms[r][c] == 0) {
                    queue.addLast(Pair(r, c))
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr !in 0 until m || nc !in 0 until n) {
                    continue
                }
                if (rooms[nr][nc] == -1) {
                    continue
                }
                if (rooms[nr][nc] > rooms[r][c] + 1) {
                    rooms[nr][nc] = rooms[r][c] + 1
                    queue.addLast(Pair(nr, nc))
                }
            }
        }
    }
}