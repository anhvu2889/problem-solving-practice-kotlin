package topic.backtracking

/**
 * 39. Combination Sum
 * Time: O(n ^ (target / min)
 * Space: O(target / min)
 */
class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        backtrack(candidates, 0, target, path, result)
        return result
    }

    fun backtrack(
        candidates: IntArray,
        index: Int,
        remain: Int,
        path: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (remain == 0) {
            result.add(path.toList())
            return
        }

        for (i in index until candidates.size) {
            val num = candidates[i]
            if (remain < num)
                break
            path.add(num)
            backtrack(candidates, i, remain - num, path, result)
            path.removeAt(path.size - 1)
        }
    }
}