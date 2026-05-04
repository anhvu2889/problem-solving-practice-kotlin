package top150.array

/**
 * 88. Merge Sorted Array
 * Time: O(n)
 * Space: O(1)
 */
class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var w = m + n - 1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[w] = nums1[i]
                i--
            } else {
                nums1[w] = nums2[j]
                j--
            }
            w--
        }
        while (j >= 0) {
            nums1[w] = nums2[j]
            j--
            w--
        }
    }
}