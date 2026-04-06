package blind75.stack

/**
 * 901. Online Stock Span
 * Time: O(n)
 * Space: O(n)
 */
class OnlineStockSpan() {
    private val stack = ArrayDeque<Pair<Int, Int>>()
    fun next(price: Int): Int {
        var span = 1
        while (stack.isNotEmpty() && stack.last().first <= price) {
            span += stack.removeLast().second
        }
        stack.addLast(Pair(price, span))
        return span
    }
}