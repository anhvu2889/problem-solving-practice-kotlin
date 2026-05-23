package top150.stack

/**
 * 20. Valid Parentheses
 * Time: O(n)
 * Space: O(n)
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '(', '{','[' -> stack.addFirst(c)
                else -> {
                    if (stack.isEmpty())
                        return false
                    val open = stack.removeFirst()
                    if(!isPair(open, c))
                        return false
                }
            }
        }
        return stack.isEmpty()
    }

    fun isPair(open: Char, close: Char): Boolean {
        return when (open) {
            '('-> close == ')'
            '{'-> close == '}'
            '['-> close == ']'
            else -> false
        }
    }
}