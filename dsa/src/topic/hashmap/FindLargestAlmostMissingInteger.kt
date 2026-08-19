package topic.hashmap

/**
 * 3471. Find the Largest Almost Missing Integer
 * Time: O(n)
 * Space: O(1)
 */
class FindLargestAlmostMissingInteger {
    fun largestInteger(nums: IntArray, k: Int): Int {
        val n = nums.size
        val freq = IntArray(51)
        for (num in nums) {
            freq[num]++
        }
        if (k == n) {
            return nums.max()
        }
        if (k == 1) {
            for (num in freq.size - 1 downTo 1) {
                if (freq[num] == 1)
                    return num
            }
        }
        val left = if (freq[nums[0]] == 1) nums[0] else -1
        val right = if (freq[nums[n - 1]] == 1) nums[n - 1] else -1
        return maxOf(left, right)
    }
}