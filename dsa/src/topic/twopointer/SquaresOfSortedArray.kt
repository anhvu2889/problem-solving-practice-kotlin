package topic.twopointer

/**
 * 977. Squares of a Sorted Array
 * Time: O(n)
 * Space: O(n)
 */
class SquaresOfSortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        var result = IntArray(nums.size)
        var l = 0
        var r = nums.size - 1
        var i = nums.size - 1
        while (i >= 0) {
            val leftSquare = nums[l] * nums[l]
            val rightSquare = nums[r] * nums[r]
            if (leftSquare < rightSquare) {
                r--
                result[i] = rightSquare
            } else {
                l++
                result[i] = leftSquare
            }
            i--
        }
        return result
    }
}