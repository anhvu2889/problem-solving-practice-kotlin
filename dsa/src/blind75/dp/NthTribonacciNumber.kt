package blind75.dp

/**
 * 1137. N-th Tribonacci Number
 * Time: O(n)
 * Space: O(1)
 */
class NthTribonacciNumber {
    fun tribonacci(n: Int): Int {
        if (n == 0)
            return 0
        if (n < 3)
            return 1
        var prev3 = 0
        var prev2 = 1
        var prev1 = 1
        for (i in 3..n) {
            val cur = prev1 + prev2 + prev3
            prev3 = prev2
            prev2 = prev1
            prev1 = cur
        }
        return prev1
    }
}