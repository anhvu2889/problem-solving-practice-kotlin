package topic.dp

/**
 * 3739. Count Subarrays With Majority Element II
 * Time: O(n)
 * Space: O(n)
 */
class CountSubarrayWithMajorityElementII {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
        val size = nums.size
        val offset = size
        val countOfBalance = IntArray(2 * size + 2)
        var balance = 0
        countOfBalance[balance + offset]++
        var smallerSeen = 0
        var totalSubarrays = 0L
        for (num in nums) {
            val step = if (num == target) 1 else -1
            balance += step
            val index = balance + offset
            if (step == 1) {
                smallerSeen += countOfBalance[index - 1]
            } else {
                smallerSeen -= countOfBalance[index]
            }
            totalSubarrays += smallerSeen
            countOfBalance[index]++
        }
        return totalSubarrays
    }
}