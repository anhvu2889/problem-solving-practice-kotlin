package topic.array

/**
 * 1752. Check if Array Is Sorted and Rotated
 * Time: O(n)
 * Space: O(1)
 */
class CheckIfArraySortedAndRotated {
    fun check(nums: IntArray): Boolean {
        var count = 0
        val n = nums.size
        for (i in nums.indices) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++
            }
        }
        return count <= 1
    }
}