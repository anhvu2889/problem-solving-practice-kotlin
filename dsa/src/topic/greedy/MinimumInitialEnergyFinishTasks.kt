package topic.greedy

/**
 * 1665. Minimum Initial Energy to Finish Tasks
 * Time: O(n * log(n))
 * Space: O(n)
 */
class MinimumInitialEnergyFinishTasks {
    fun minimumEffort(tasks: Array<IntArray>): Int {
        tasks.sortWith {t1, t2 -> (t2[1] - t2[0]) - (t1[1] - t1[0])}
        var totalEnergy = 0
        var currentEnergy = 0
        for (task in tasks) {
            val actual = task[0]
            val min = task[1]
            if (currentEnergy < min) {
                val gap = min - currentEnergy
                currentEnergy += gap
                totalEnergy += gap
            }
            currentEnergy -= actual
        }
        return totalEnergy
    }
}