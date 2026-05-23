package top150.stack

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

class MinStack() {
    private val valueStack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()
    fun push(`val`: Int) {
        valueStack.addLast(`val`)
        if (minStack.isNotEmpty()) {
            minStack.addLast(minOf(`val`, minStack.last()))
        } else {
            minStack.addLast(`val`)
        }
    }

    fun pop() {
        valueStack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return valueStack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}

