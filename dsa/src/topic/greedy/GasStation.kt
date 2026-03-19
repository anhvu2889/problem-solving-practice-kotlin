package topic.greedy

/**
 * 134. Gas Station
 * Time: O(n)
 * Space: O(1)
 */
class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var remainTank = 0
        var currentTank = 0
        var start = 0
        for (i in gas.indices) {
            val diff = gas[i] - cost[i]
            remainTank += diff
            currentTank += diff
            if (currentTank < 0) {
                start = i + 1
                currentTank = 0
            }
        }
        if (remainTank < 0)
            return -1
        return start
    }
}