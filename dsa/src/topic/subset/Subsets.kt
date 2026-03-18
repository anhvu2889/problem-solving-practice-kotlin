package topic.subset

/**
 * 78. Subsets
 * Time Complexity: O(n x 2^n)
 * Space Complexity: O(n x 2^n)
 */
class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        dfs(nums, 0, mutableListOf(), result)
        return result
    }

    fun dfs(nums: IntArray, start: Int, path: MutableList<Int>, result: MutableList<List<Int>>) {
        result.add(ArrayList(path))
        for (i in start until nums.size) {
            path.add(nums[i])
            dfs(nums, i + 1, path, result)
            path.removeAt(path.size - 1)
        }
    }
}