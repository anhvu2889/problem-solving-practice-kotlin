package topic.matrix

class TetrisFigurePlacement {
    fun placeShapes(grid: Array<IntArray>, arrivals: List<String>): Array<IntArray> {
        if (grid.isEmpty()) {
            return grid
        }
        val mapShapes = buildShapes()
        for (i in arrivals.indices) {
            val label = i + 1
            val shape = mapShapes[arrivals[i]] ?: continue
            val fitPos = findFitPos(grid, shape)
            if (fitPos[0] == -1) {
                continue
            }
            place(grid, shape, fitPos[0], fitPos[1], label)
        }
        return grid
    }

    private fun buildShapes(): Map<String, Array<IntArray>> {
        val map = HashMap<String, Array<IntArray>>()
        map["A"] = arrayOf(intArrayOf(1))
        map["B"] = arrayOf(intArrayOf(1, 1, 1))
        map["C"] = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        map["D"] = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
        map["E"] = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        return map
    }

    private fun findFitPos(grid: Array<IntArray>, shape: Array<IntArray>): IntArray {
        val m = grid.size
        val n = grid[0].size
        val h = shape.size
        val w = shape[0].size
        if (h > m || w > n) {
            return intArrayOf(-1, -1)
        }
        for (top in 0..m - h)
            for (left in 0..n - w) {
                if (isFit(grid, shape, top, left)) {
                    return intArrayOf(top, left)
                }
            }
        return intArrayOf(-1, -1)
    }

    private fun isFit(grid: Array<IntArray>, shape: Array<IntArray>, top: Int, left: Int): Boolean {
        val h = shape.size
        val w = shape[0].size
        for (r in 0 until h) {
            val dr = top + r
            for (c in 0 until w) {
                val dc = c + left
                if (shape[r][c] == 0) {
                    continue
                }
                if (grid[dr][dc] != 0) {
                    return false
                }
            }
        }
        return true
    }

    private fun place(grid: Array<IntArray>, shape: Array<IntArray>, top: Int, left: Int, label: Int) {
        val h = shape.size
        val w = shape[0].size
        for (r in 0 until h) {
            val dr = top + r
            for (c in 0 until w) {
                val dc = c + left
                if (shape[r][c] == 0) {
                    continue
                }
                grid[dr][dc] = label
            }
        }
    }
}