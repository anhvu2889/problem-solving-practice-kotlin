package topic.prefixsum

/**
 * 560. Subarray Sum Equals K
 * Time: O(n)
 * Space: O(1)
 */
class SubarraySumEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val n = nums.size
        var sum = 0
        val seen = HashMap<Int, Int>()
        seen[0] = 1
        var count = 0
        for (num in nums) {
            sum += num
            val need = sum - k
            count += seen.getOrDefault(need, 0)
            seen[sum] = seen.getOrDefault(sum, 0) + 1
        }
        return count

    }
}