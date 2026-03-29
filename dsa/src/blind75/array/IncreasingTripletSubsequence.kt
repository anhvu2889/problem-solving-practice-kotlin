package blind75.array

/**
 * 334. Increasing Triplet Subsequence
 * Time: O(n)
 * Space: O(1)
 */
class IncreasingTripletSubsequence {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3)
            return false
        var l = Int.MAX_VALUE
        var r = Int.MAX_VALUE
        for (num in nums) {
            if (num <= l) {
                l = num
            } else if (num <= r) {
                r = num
            } else {
                return true
            }
        }
        return false
    }
}