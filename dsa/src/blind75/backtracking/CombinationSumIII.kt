package blind75.backtracking

/**
 * 216. Combination Sum III
 * Time: O(k (9 k)
 * Space: O(k)
 */
class CombinationSumIII {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        backtrack(1, k, n, path, result)
        return result
    }

    fun backtrack(start: Int, k: Int, remain: Int, path: MutableList<Int>, result: MutableList<List<Int>>) {
        if (path.size == k) {
            if (remain == 0)
                result.add(path.toList())
            return
        }
        if (remain < 0)
            return
        val need = k - path.size
        val maxNum = 9 - need + 1
        for (i in start..maxNum) {
            path.add(i)
            backtrack(i + 1, k, remain - i, path, result)
            path.removeLast()
        }
    }
}