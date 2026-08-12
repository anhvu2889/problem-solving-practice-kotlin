package top150.math

/**
 * 50. Pow(x, n)
 * Time:
 * Space:
 */
class Pow {
    fun myPow(x: Double, n: Int): Double {
        var exp = Math.abs(n.toLong())
        var base = x
        var result = 1.0
        while (exp > 0) {
            if (exp and 1L == 1L) {
                result *= base
            }
            base *= base
            exp = exp shr 1
        }
        return if (n < 0) 1.0 / result else result
    }
}