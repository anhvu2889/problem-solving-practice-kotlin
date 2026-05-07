package top150.twopointer


/**
 * 167. Two Sum II - Input Array Is Sorted
 * Time:
 * Space
 */
class TwoSumIIInputArrayIsSorted {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        while (l < r) {
            val sum = numbers[l] + numbers[r]
            if (sum > target) {
                r--
            } else if (sum < target) {
                l++
            } else {
                return intArrayOf(l + 1, r + 1)
            }
        }
        return intArrayOf(0, 0)
    }
}