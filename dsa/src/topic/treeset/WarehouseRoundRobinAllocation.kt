package topic.treeset

import java.util.*

class WarehouseRoundRobinAllocation {
    fun busiestWarehouse(capacity: IntArray, dailyLogs: Array<String>): Int {
        val n = capacity.size
        val remaining = capacity.copyOf()
        val openSet = HashSet<Int>()
        val availableSet = TreeSet<Int>()
        val handled = IntArray(n)
        for (i in 0 until n) {
            if (capacity[i] <= 0) {
                continue
            }
            availableSet.add(i)
            openSet.add(i)
        }
        for (log in dailyLogs) {
            if (log.equals("PACKAGE")) {
                dispatch(capacity, remaining, handled, openSet, availableSet)
            } else {
                val closure = log.split(" ")[1].toInt()
                openSet.remove(closure)
                availableSet.remove(closure)
            }
        }
        return maxHandled(handled)
    }

    private fun dispatch(
        capacity: IntArray,
        remaining: IntArray,
        handled: IntArray,
        openSet: HashSet<Int>,
        availableSet: TreeSet<Int>
    ) {
        if (availableSet.isEmpty() && !reset(capacity, remaining, openSet, availableSet)) {
            return
        }

        val target = availableSet.first()
        remaining[target]--
        handled[target]++
        if (remaining[target] == 0) {
            availableSet.remove(target)
        }
    }

    private fun reset(
        capacity: IntArray,
        remaining: IntArray,
        openSet: HashSet<Int>,
        availableSet: TreeSet<Int>
    ): Boolean {
        if (openSet.isEmpty()) {
            return false
        }
        for (i in openSet) {
            remaining[i] = capacity[i]
            availableSet.add(i)
        }
        return true
    }

    private fun maxHandled(handled: IntArray): Int {
        var max = 0
        for (i in handled.indices) {
            if (handled[i] >= max) {
                max = i
            }
        }
        return max
    }
}