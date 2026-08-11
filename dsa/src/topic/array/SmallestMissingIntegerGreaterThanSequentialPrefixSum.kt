package topic.array

/**
 * 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 * Time: O(n)
 * Space: O(n)
 */
class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    fun missingInteger(nums: IntArray): Int {
        var sum = nums[0]
        for (i in 1..<nums.size) {
            if (nums[i] != nums[i - 1] + 1)
                break
            sum += nums[i]
        }
        val seen = HashSet<Int>()
        for (num in nums) {
            seen.add(num)
        }
        var x = sum
        while (x in seen) {
            x++
        }
        return x
    }
}