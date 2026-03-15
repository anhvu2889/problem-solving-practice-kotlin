package topic.binarysearch

/**
 * 410. Split Array Largest Sum
 * Time: O(nlog(n))
 * Space: O(1)
 */
class SplitArrayLargestSum {
    fun splitArray(nums: IntArray, k: Int): Int {
        var l = 0
        var r = 0
        for (num in nums) {
            l = maxOf(l, num)
            r += num
        }
        while (l < r) {
            val mid = l + (r - l) / 2
            var parts = 1
            var sum = 0
            for (num in nums) {
                if (sum + num > mid) {
                    sum = num
                    parts++
                } else {
                    sum += num
                }
            }
            if (parts <= k) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l
    }
}