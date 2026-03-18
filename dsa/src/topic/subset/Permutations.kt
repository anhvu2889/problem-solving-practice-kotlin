package topic.subset

/**
 * 46. Permutations
 * Time: O(n x n!)
 * Space: O(n x n!)
 */
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        var result = mutableListOf<List<Int>>()
        var path = mutableListOf<Int>()
        var mark = BooleanArray(nums.size)
        backtrack(nums, path, result, mark)
        return result
    }

    fun backtrack(nums: IntArray, path: MutableList<Int>, result: MutableList<List<Int>>, mark: BooleanArray) {
        if (path.size == nums.size) {
            result.add(ArrayList(path))
            return
        }
        for (i in nums.indices) {
            if (mark[i]) {
                continue
            }
            path.add(nums[i])
            mark[i] = true
            backtrack(nums, path, result, mark)
            mark[i] = false
            path.removeAt(path.size - 1)
        }
    }
}