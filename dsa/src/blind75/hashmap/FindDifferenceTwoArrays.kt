package blind75.hashmap

/**
 * 2215. Find the Difference of Two Arrays
 * Time: O(n + m)
 * Space: O(n + m)
 */
class FindDifferenceTwoArrays {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        val diff1 = mutableListOf<Int>()
        val diff2 = mutableListOf<Int>()
        for (num in set1) {
            if (num !in set2) {
                diff1.add(num)
            }
        }
        for (num in set2) {
            if (num !in set1) {
                diff2.add(num)
            }
        }
        return listOf(diff1, diff2)
    }
}