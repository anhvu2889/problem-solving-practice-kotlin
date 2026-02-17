package topic.slidingwindow

/**
 * 1838. Frequency of the Most Frequent Element
 * Time: O(nlog(n))
 * Space: O(1)
 */
class FrequencyOfMostFrequentElement {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()
        var l = 0
        var max = 0
        var sum = 0L
        for (r in nums.indices) {
            sum += nums[r]
            while ((r - l + 1).toLong() * nums[r] > sum + k &&  l <= r) {
                sum -= nums[l]
                l++
            }
            max = maxOf(r - l + 1, max)
        }
        return max
    }
}