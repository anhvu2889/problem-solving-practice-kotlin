package topic.array

/**
 * 2784. Check if Array is Good
 * Time: O(n)
 * Space: O(1)
 */
class CheckIfArrayGood {
    fun isGood(nums: IntArray): Boolean {
        val freq = IntArray(201)
        val n = nums.size - 1
        for (num in nums) {
            if ((num > n) || (num != n && freq[num] > 0))
                return false
            else
                freq[num]++
        }
        return freq[n] == 2
    }
}