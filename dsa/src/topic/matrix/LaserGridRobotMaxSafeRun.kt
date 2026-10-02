package topic.matrix

class LaserGridRobotMaxSafeRun {
    fun maxSafeRun(numRows: Int, numColumns: Int, curRow: Int, curColumn: Int, laserCoordinates: Array<IntArray>): Int {
        val blockedRow = BooleanArray(numRows)
        val blockedCol = BooleanArray(numColumns)
        for (lazer in laserCoordinates) {
            blockedRow[lazer[0]] = true
            blockedCol[lazer[1]] = true
        }
        val dr = intArrayOf(0, 0, 1, -1)
        val dc = intArrayOf(1, -1, 0, 0)
        var max = 0
        for (i in 0 until 4) {
            var r = curRow
            var c = curColumn
            var step = 0
            while (true) {
                r += dr[i]
                c += dc[i]
                if (r in 0 until numRows && c in 0 until numColumns && !blockedRow[r] && !blockedCol[c]) {
                    step++
                } else {
                    break
                }
            }
            max = maxOf(max, step)
        }
        return max
    }
}