package topic.bitwise

class LongestSubsequenceNonZeroBitwiseXOR {
    fun longestSubsequence(nums: IntArray): Int {
        var totalXOR = 0
        var hasNonZero = false
        for (num in nums) {
            totalXOR = totalXOR xor num
            if (num != 0)
                hasNonZero = true
        }
        if (totalXOR != 0)
            return nums.size
        else {
            if (hasNonZero)
                return nums.size - 1
            else
                return 0
        }
    }
}