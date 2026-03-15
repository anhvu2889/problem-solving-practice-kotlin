package topic.binarysearch

/**
 * 1802. Maximum Value at a Given Index in a Bounded Array
 * Time: O(nlog(n))
 * Space: O(1)
 */
class MaximumValueAtGivenIndexInBoundedArray {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        var l = 1
        var r = maxSum
        var result = 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (calSum(n, mid.toLong(), index) > maxSum) {
                r = mid - 1
            } else {
                result = mid
                l = mid + 1
            }
        }
        return result
    }

    fun sideSum(max: Long, length: Long): Long {
        if (max >= length) {
            val min = max - length + 1
            return (max + min) * length / 2
        } else {
            val sumOfOne = length - max
            return (max + 1) * max / 2 + sumOfOne
        }
    }

    fun calSum(n: Int, value: Long, index: Int): Long {
        var sum = value
        val leftSum = sideSum(value - 1, index.toLong())
        val rightSum = sideSum(value - 1, (n - index - 1).toLong())
        return sum + leftSum + rightSum
    }
}