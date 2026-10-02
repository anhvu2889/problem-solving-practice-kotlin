package topic.dp

/**
 * 3101. Count Alternating Subarrays
 * Time: O(n)
 * Space: O(1)
 */
class CountAlternatingSubarrays {
    fun countAlternatingSubarrays(nums: IntArray): Long {
        val n = nums.size
        var count = 1L
        var prevLen = 1
        for (new in 1 until n) {
            if (nums[new] != nums[new - 1]) {
                count += prevLen
                prevLen++
            } else {
                prevLen = 1
            }
            count++
        }
        return count
    }
}