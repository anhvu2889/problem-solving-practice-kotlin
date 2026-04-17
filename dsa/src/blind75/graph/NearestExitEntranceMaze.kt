package blind75.graph

/**
 * 1926. Nearest Exit from Entrance in Maze
 * Time: O(m * n)
 * Space: O(m * n)
 */
class NearestExitEntranceMaze {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val rows = maze.size
        val cols = maze[0].size
        val queue = ArrayDeque<Pair<Int, Int>>()
        val directions = intArrayOf(1, 0, -1, 0, 1)
        queue.addLast(entrance[0] to entrance[1])
        maze[entrance[0]][entrance[1]] = '+'
        var steps = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) {
                val (r, c) = queue.removeFirst()
                for (i in 0 until 4) {
                    val nr = r + directions[i]
                    val nc = c + directions[i + 1]
                    if (nr !in 0 until rows || nc !in 0 until cols) continue
                    if (maze[nr][nc] == '+') continue
                    if (nr == 0 || nr == rows - 1 || nc == 0 || nc == cols - 1) {
                        return steps + 1
                    }
                    maze[nr][nc] = '+'
                    queue.addLast(nr to nc)
                }
            }
            steps++
        }
        return -1
    }
}