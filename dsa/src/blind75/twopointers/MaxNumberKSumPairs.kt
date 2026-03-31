package blind75.twopointers

/**
 * 1679. Max Number of K-Sum Pairs
 * Time:
 * Space:
 */
class MaxNumberKSumPairs {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var count = 0
        val freqMap = HashMap<Int, Int>()
        for (num in nums) {
            val remain = k - num
            val available = freqMap.getOrDefault(remain, 0)
            if (available > 0) {
                count++
                freqMap[remain] = available - 1
            } else {
                freqMap[num] = freqMap.getOrDefault(num, 0) + 1
            }
        }
        return count
    }
}