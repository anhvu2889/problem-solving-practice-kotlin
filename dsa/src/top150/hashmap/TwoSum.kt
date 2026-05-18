package top150.hashmap

/**
 * 1. Two Sum
 * Time: O(n)
 * Space: O(n)
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val cur = nums[i]
            val need = target - cur
            if (map.contains(need))
                return intArrayOf(i, map[need]!!)
            map[cur] = i
        }
        return intArrayOf(-1, -1)
    }
}