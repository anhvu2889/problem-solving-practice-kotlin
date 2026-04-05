package blind75.hashmap

/**
 * 2352. Equal Row and Column Pairs
 * Time: O(n^2)
 * Space: O(n^2)
 */
class EqualRowAndColumnPairs {
    fun equalPairs(grid: Array<IntArray>): Int {
        var count = 0
        val n = grid.size
        val map = HashMap<List<Int>, Int>()
        for (row in grid) {
            val key = row.toList()
            map[key] = map.getOrDefault(key, 0) + 1
        }
        for (col in 0..<n) {
            val key = mutableListOf<Int>()
            for (row in 0..<n) {
                key.add(grid[row][col])
            }
            count += map.getOrDefault(key, 0)
        }
        return count
    }
}