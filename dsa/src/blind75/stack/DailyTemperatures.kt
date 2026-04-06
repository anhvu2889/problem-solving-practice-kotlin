package blind75.stack

/**
 * 739. Daily Temperatures
 * Time: O(n)
 * Space: O(n)
 */
class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val last = stack.removeLast()
                result[last] = i - last
            }
            stack.addLast(i)
        }
        return result
    }
}