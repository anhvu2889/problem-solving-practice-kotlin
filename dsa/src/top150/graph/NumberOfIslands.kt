package top150.graph

/**
 * 200. Number of Islands
 * Time: O(n * m)
 * Space: O(min(n, m))
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var ans = 0
        val n = grid.size
        val m = grid[0].size
        val adj = intArrayOf(-1, 0, 1, 0, -1)
        for (r in 0 until n) {
            for (c in 0 until m) {
                if (grid[r][c] == '0')
                    continue
                val queue = ArrayDeque<Pair<Int, Int>>()
                queue.addFirst(Pair(r, c))
                grid[r][c] = '0'
                while (queue.isNotEmpty()) {
                    val pair = queue.removeLast()
                    for (i in 0 until 4) {
                        val adjR = pair.first + adj[i]
                        val adjC = pair.second + adj[i + 1]
                        if (adjR !in 0..<n || adjC !in 0..<m || grid[adjR][adjC] == '0')
                            continue
                        queue.addFirst(Pair(adjR, adjC))
                        grid[adjR][adjC] = '0'
                    }
                }
                ans++
            }
        }
        return ans
    }
}