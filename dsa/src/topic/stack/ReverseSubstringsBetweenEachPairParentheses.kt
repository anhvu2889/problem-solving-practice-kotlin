package topic.stack

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * Time:
 * Space:
 */
class ReverseSubstringsBetweenEachPairParentheses {
    fun reverseParentheses(s: String): String {
        val n = s.length
        val openStack = ArrayDeque<Int>()
        val pair = IntArray(n)
        for (end in s.indices) {
            when (s[end]) {
                '(' -> {
                    openStack.addLast(end)
                }

                ')' -> {
                    val start = openStack.removeLast()
                    pair[start] = end
                    pair[end] = start
                }
            }
        }
        return readReverse(s, pair)
    }

    private fun readReverse(s: String, pair: IntArray): String {
        val n = s.length
        val ans = StringBuilder()
        var readDirection = 1
        var i = 0
        while (i < n) {
            when (s[i]) {
                '(', ')' -> {
                    i = pair[i]
                    readDirection *= -1
                }
                else -> {
                    ans.append(s[i])
                }
            }
            i += readDirection
        }
        return ans.toString()
    }
}