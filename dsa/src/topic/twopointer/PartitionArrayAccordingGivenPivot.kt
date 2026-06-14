package topic.twopointer

/**
 * 2161. Partition Array According to Given Pivot
 * Time: O(n)
 * Space: O(n)
 */
class PartitionArrayAccordingGivenPivot {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val n = nums.size
        val ans = IntArray(n)
        var l = 0
        var r = n - 1
        for (i in nums.indices) {
            if (nums[i] < pivot) {
                ans[l] = nums[i]
                l++
            }
            if (nums[n - 1 - i] > pivot) {
                ans[r] = nums[n - 1 - i]
                r--
            }
        }
        for (i in l..r){
            ans[i] = pivot
        }
        return ans
    }
}