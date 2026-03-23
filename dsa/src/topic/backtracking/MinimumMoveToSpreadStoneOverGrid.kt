package topic.backtracking

import kotlin.math.abs

/**
 * 2850. Minimum Moves to Spread Stones Over Grid
 * Time: O(k!) as k is number of empty cells
 * Space: O(k)
 */
class MinimumMoveToSpreadStoneOverGrid {
    fun minimumMoves(grid: Array<IntArray>): Int {
        val emptyCells = mutableListOf<IntArray>()
        val extraStones = mutableListOf<IntArray>()
        for (row in 0 until 3) {
            for (col in 0 until 3) {
                val stones = grid[row][col]
                if (stones == 0) {
                    emptyCells.add(intArrayOf(row, col))
                }
                if (stones > 1) {
                    repeat(stones - 1) {
                        extraStones.add(intArrayOf(row, col))
                    }
                }
            }
        }
        val usedStones = BooleanArray(extraStones.size)
        return backtrack(emptyCells, extraStones, 0, usedStones)
    }

    fun backtrack(
        emptyCells: MutableList<IntArray>,
        extraStones: MutableList<IntArray>,
        index: Int,
        usedStones: BooleanArray
    ): Int {
        if (index == emptyCells.size) {
            return 0
        }
        var result = Int.MAX_VALUE
        val emptyRow = emptyCells[index][0]
        val emptyCol = emptyCells[index][1]
        for (i in extraStones.indices) {
            if (usedStones[i])
                continue
            usedStones[i] = true
            val extraRow = extraStones[i][0]
            val extraCol = extraStones[i][1]
            val moveCost = abs(extraRow - emptyRow) + abs(extraCol - emptyCol)
            result = minOf(result, moveCost + backtrack(emptyCells, extraStones, index + 1, usedStones))
            usedStones[i] = false
        }
        return result
    }
}