package topic.array

/**
 * 3731. Find Missing Elements
 * Time: O(n + m)
 * Space: O(m)
 */
class FindMissingElements {
    fun findMissingElements(nums: IntArray): List<Int> {
        val n = nums.size
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (num in nums) {
            min = minOf(min, num)
            max = maxOf(max, num)
        }
        val freq = IntArray(max - min)
        for (num in nums) {
            freq[num - min]++
        }
        val ans = mutableListOf<Int>()
        for (i in freq.indices) {
            if (freq[i] == 0)
                ans.add(i + min)
        }
        return ans
    }
}