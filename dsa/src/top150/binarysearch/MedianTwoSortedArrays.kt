package top150.binarysearch

/**
 * 4. Median of Two Sorted Arrays
 * Time: O(log(min(m, n))
 * Space: O(1)
 */
class MedianTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val a = if (nums1.size <= nums2.size) nums1 else nums2
        val b = if (nums1.size <= nums2.size) nums2 else nums1
        val m = a.size
        val n = b.size
        var l = 0
        var r = m
        val len = (m + n + 1) / 2
        while (true) {
            val i = l + (r - l) / 2
            val j = len - i
            val aL = if (i == 0) Int.MIN_VALUE else a[i - 1]
            val aR = if (i == m) Int.MAX_VALUE else a[i]
            val bL = if (j == 0) Int.MIN_VALUE else b[j - 1]
            val bR = if (j == n) Int.MAX_VALUE else b[j]
            if (aL <= bR && bL <= aR) {
                if ((m + n) % 2 == 1)
                    return maxOf(aL, bL).toDouble()
                else
                    return (maxOf(aL, bL) + minOf(aR, bR)) / 2.0
            } else if (aL > bR) {
                r = i - 1
            } else {
                l = i + 1
            }
        }
    }
}