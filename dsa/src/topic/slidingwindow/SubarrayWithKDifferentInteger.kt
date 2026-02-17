package topic.slidingwindow

/**
 * 992. Subarrays with K Different Integers
 * Time: O(n)
 * Space: O(k)
 */
class SubarrayWithKDifferentInteger {
    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        return subarraysAtMostKDistinct(nums, k) - subarraysAtMostKDistinct(nums, k - 1)
    }

    fun subarraysAtMostKDistinct(nums: IntArray, k: Int): Int {
        var count = 0
        var l = 0
        val map = mutableMapOf<Int, Int>()
        var s = 0
        for (r in nums.indices) {
            map[nums[r]] = map.getOrDefault(nums[r], 0) + 1
            if (map[nums[r]] == 1) {
                s++
            }
            while (s > k) {
                map[nums[l]] = map.getOrDefault(nums[l], 0) - 1
                if (map[nums[l]] == 0) {
                    s--
                }
                l++
            }
            count += r - l + 1
        }
        return count
    }
}