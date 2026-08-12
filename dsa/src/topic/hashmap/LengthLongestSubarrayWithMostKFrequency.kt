package topic.hashmap

/**
 * 2958. Length of Longest Subarray With at Most K Frequency
 * Time: O(n)
 * Space: O(n)
 */
class LengthLongestSubarrayWithMostKFrequency {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val freqMap = HashMap<Int, Int>()
        var maxLen = 0
        var l = 0
        for (r in nums.indices) {
            val num = nums[r]
            val freq = freqMap.getOrDefault(num, 0) + 1
            freqMap[num] = freq
            while (freqMap[num] != null && freqMap[num]!! > k) {
                val leftValue = nums[l]
                freqMap[leftValue] = freqMap[leftValue]!! - 1
                l++
            }

            maxLen = maxOf(maxLen, r - l + 1)
        }
        return maxLen
    }
}