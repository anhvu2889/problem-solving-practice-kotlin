package top150.stack

/**
 * 150. Evaluate Reverse Polish Notation
 * Time: O(n)
 * Space: O(n)
 */
class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                val second = stack.removeLast()
                val first = stack.removeLast()
                when (token) {
                    "+" -> stack.add(first + second)
                    "-" -> stack.add(first - second)
                    "*" -> stack.add(first * second)
                    "/" -> stack.add(first / second)
                }
            } else {
                stack.addLast(token.toInt())
            }
        }
        return stack.removeLast()
    }
}