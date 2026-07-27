package topic.math

class MaximumProductThreeNumbers {
    fun maximumProduct(nums: IntArray): Int {
        var r1 = Int.MIN_VALUE
        var r2 = Int.MIN_VALUE
        var r3 = Int.MIN_VALUE
        var l1 = Int.MAX_VALUE
        var l2 = Int.MAX_VALUE
        for (num in nums) {
            if (num > r1) {
                r3 = r2
                r2 = r1
                r1 = num
            } else if (num > r2) {
                r3 = r2
                r2 = num
            } else if (num > r3) {
                r3 = num
            }
            if (num < l1) {
                l2 = l1
                l1 = num
            } else if (num < l2) {
                l2 = num
            }
        }
        return maxOf(r1 * r2 * r3, l1 * l2 * r1)
    }
}