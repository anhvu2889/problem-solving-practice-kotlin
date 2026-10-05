package topic.twopointer

/**
 * 32. Longest Valid Parentheses
 * Time: O(n)
 * Space: O(1)
 */
class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val n = s.length
        var max = 0
        var balance = 0
        var start = 0
        for (end in 0 until n) {
            val char = s[end]
            if (char == '(') {
                balance++
            } else {
                balance--
                if (balance == 0) {
                    max = maxOf(max, end - start + 1)
                } else if (balance < 0) {
                    start = end + 1
                    balance = 0
                }
            }
        }
        balance = 0
        start = n - 1
        for (end in n - 1 downTo 0) {
            var char = s[end]
            if (char == ')') {
                balance++
            } else {
                balance--
                if (balance == 0) {
                    max = maxOf(max, start - end + 1)
                } else if (balance < 0) {
                    start = end - 1
                    balance = 0
                }
            }
        }
        return max
    }
}