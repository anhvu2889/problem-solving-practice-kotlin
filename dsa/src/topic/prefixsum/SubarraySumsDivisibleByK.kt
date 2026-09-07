package topic.prefixsum

/**
 * 974. Subarray Sums Divisible by K
 * Time: O(n)
 * Space: O(1)
 */
class SubarraySumsDivisibleByK {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val seen = HashMap<Int, Int>()
        var sum = 0
        seen[0] = 1
        var total = 0
        for (num in nums) {
            sum += num
            val need = ((sum % k) + k ) % k
            total += seen.getOrDefault(need, 0)
            seen[need] = seen.getOrDefault(need, 0) + 1
        }
        return total
    }
}