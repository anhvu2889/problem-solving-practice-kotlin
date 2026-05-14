package topic.prefixsum

/**
 * 1674. Minimum Moves to Make Array Complementary
 * Time:
 * Space:
 */
class MinimumMovesMakeArrayComplementary {
    fun minMoves(nums: IntArray, limit: Int): Int {
        val diff = IntArray(2 * limit + 2)
        val n = nums.size
        for (i in 0 until n / 2) {
            val low = minOf(nums[i], nums[n - i - 1])
            val high = maxOf(nums[i], nums[n - i - 1])
            val sum = low + high

            diff[2] += 2
            diff[limit * 2 + 1] -= 2

            diff[low + 1] -= 1
            diff[high + limit + 1] += 1

            diff[sum] -= 1
            diff[sum + 1] += 1
        }
        val prefixSum = IntArray(2 * limit + 2)
        var ans = Int.MAX_VALUE
        for (target in 2..limit * 2) {
            prefixSum[target] = prefixSum[target - 1] + diff[target]
            ans = minOf(ans, prefixSum[target])
        }
        return ans
    }
}