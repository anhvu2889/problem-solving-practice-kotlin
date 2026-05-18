package top150.hashmap

/**
 * 202. Happy Number
 * Time: O(log(n))
 * Space: O(1)
 */
class HappyNumber {
    fun isHappy(n: Int): Boolean {
        var s = n
        var f = next(s)
        while (f != 1 && f != s) {
            s = next(s)
            f = next(next(f))
        }
        return f == 1
    }

    fun next(n: Int): Int {
        var cur = n
        var sum = 0
        while (cur > 0) {
            val digit = cur % 10
            sum += digit * digit
            cur /= 10
        }
        return sum
    }
}