package top150.stack

/**
 * 224. Basic Calculator
 * Time: O(n)
 * Space: O(n)
 */
class BasicCalculator {
    fun calculate(s: String): Int {
        val stack = ArrayDeque<Int>()
        var i = 0
        val n = s.length
        var sum = 0
        var sign = 1
        while (i < n) {
            val c = s[i]
            if (c.isDigit()) {
                var num = 0
                while (i < n && s[i].isDigit()) {
                    num = num * 10 + s[i].digitToInt()
                    i++
                }
                sum += num * sign
                continue
            } else if (c == '+') {
                sign = 1
            } else if (c == '-') {
                sign = -1
            } else if (c == '(') {
                stack.addLast(sum)
                stack.addLast(sign)
                sum = 0
                sign = 1
            } else if (c == ')') {
                val lastSign = stack.removeLast()
                val lastSum = stack.removeLast()
                sum = sum * lastSign + lastSum
            }
            i++
        }
        return sum
    }
}