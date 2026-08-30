package topic.greedy

/**
 * 2091. Removing Minimum and Maximum From Array
 * Time: O(n)
 * Space: O(1)
 */
class RemovingMinimumMaximumFromArray {
    fun minimumDeletions(nums: IntArray): Int {
        val n = nums.size
        var minIndex = 0
        var maxIndex = 0
        for (i in 1 until n) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i
            }
        }
        val l = minOf(minIndex, maxIndex)
        val r = maxOf(minIndex, maxIndex)
        val leftDeletion = l - 0 + 1
        val rightDeletion = n - r
        val midDeletion = r - l
        return minOf(leftDeletion + rightDeletion, leftDeletion + midDeletion, rightDeletion + midDeletion)
    }
}