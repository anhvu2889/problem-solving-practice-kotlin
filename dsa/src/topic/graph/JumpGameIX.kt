package topic.graph

/**
 * 3660. Jump Game IX
 * Time: O(n)
 * Space: O(n)
 */
class JumpGameIX {
    fun maxValue(nums: IntArray): IntArray {
        val n = nums.size
        val prefixMax = IntArray(n)
        prefixMax[0] = nums[0]
        for (i in 1 until n) {
            prefixMax[i] = maxOf(prefixMax[i - 1], nums[i])
        }
        val suffixMin = IntArray(n)
        suffixMin[n - 1] = nums[n - 1]
        for (i in n - 2 downTo 0) {
            suffixMin[i] = minOf(suffixMin[i + 1], nums[i])
        }
        val result = IntArray(n)
        var start = 0
        for (i in nums.indices) {
            if (i == n - 1 || prefixMax[i] <= suffixMin[i + 1]) {
                for (j in start..i) {
                    result[j] = prefixMax[i]
                }
                start = i + 1
            }
        }
        return result
    }
}