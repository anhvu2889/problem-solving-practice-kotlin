package top150.math

import kotlin.math.abs

/**
 * 50. Pow(x, n)
 * Time:
 * Space:
 */
class Pow {
    fun myPow(x: Double, n: Int): Double {
        var exp = abs(n.toLong())
        var base = x
        var ans = 1.0
        while (exp > 0) {
            if (exp % 2 != 0L) {
                ans = ans * base
            }
            base *= base
            exp /= 2
        }
        return if (n < 0) 1.0 / ans else ans
    }
}