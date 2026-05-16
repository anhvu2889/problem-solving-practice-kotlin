package topic.matrix

/**
 * 2061. Number of Spaces Cleaning Robot Cleaned
 * Time: O(m * n)
 * Space: O( m * n)
 */
class NumberSpacesCleaningRobotCleaned {
    fun numberOfCleanRooms(room: Array<IntArray>): Int {
        var count = 0
        var dr = intArrayOf(0, 1, 0, -1)
        var dc = intArrayOf(1, 0, -1, 0)
        val rows = room.size
        val cols = room[0].size
        val seen = Array(rows) { Array(cols) { BooleanArray(4) } }
        val cleaned = Array(rows) { BooleanArray(cols) }
        var r = 0
        var c = 0
        var d = 0
        while (!seen[r][c][d]) {
            seen[r][c][d] = true
            if (!cleaned[r][c]) {
                count++
                cleaned[r][c] = true
            }
            val nr = r + dr[d]
            val nc = c + dc[d]
            if (nr !in 0 until rows || nc !in 0 until cols || room[nr][nc] == 1) {
                d = (d + 1) % 4
            } else {
                r = nr
                c = nc
            }
        }
        return count
    }
}