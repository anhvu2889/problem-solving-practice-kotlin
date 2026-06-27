package topic.prefixsum

/**
 * 3737. Count Subarrays With Majority Element I
 * Time: O(n)
 * Space: O(n)
 */
class CountSubarraysWithMajorityElementI {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        val n = nums.size
        val offset = n
        val countOfBalance = IntArray(2 * n + 2)
        var balance = 0
        countOfBalance[balance + offset]++
        var smallerSeen = 0
        var total = 0
        for (num in nums) {
            val step = if (num == target) 1 else -1
            balance += step
            val index = balance + offset
            if (step == 1)
                smallerSeen += countOfBalance[index - 1]
            else
                smallerSeen -= countOfBalance[index]
            total += smallerSeen
            countOfBalance[index]++
        }
        return total
    }
}