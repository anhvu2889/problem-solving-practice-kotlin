package topic.twopointer

/**
 * 2540. Minimum Common Value
 * Time: O(m + n)
 * Space: O(1)
 */
class MinimumCommonValue {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] == nums2[j])
                return nums1[i]
            else if (nums1[i] > nums2[j])
                j++
            else
                i++
        }
        return -1
    }
}