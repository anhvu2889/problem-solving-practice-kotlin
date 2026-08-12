package top150.math

/**
 * 69. Sqrt(x)
 * Time: O(log(n))
 * Space: 0(1)
 */
class SqrtX {
    fun mySqrt(x: Int): Int {
        if (x < 2)
            return x
        var l = 1
        var r = x / 2
        while (l < r) {
            val mid = l + (r - l + 1) / 2
            if (mid.toLong() * mid.toLong() <= x) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        return l
    }
}