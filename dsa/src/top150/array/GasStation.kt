package top150.array

/**
 * 134. Gas Station
 * Time: O(n)
 * Space: O(1)
 */
class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalTank = 0
        var currentTank = 0
        var start = 0
        for (i in gas.indices) {
            val net = gas[i] - cost[i]
            totalTank += net
            currentTank += net
            if (currentTank < 0) {
                start = i + 1
                currentTank = 0
            }
        }
        if (totalTank < 0)
            return -1
        else
            return start
    }
}