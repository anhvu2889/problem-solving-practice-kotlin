package topic.heap

import java.util.*

/**
 * 1942. The Number of the Smallest Unoccupied Chair
 * Time: O(nlog(n))
 * Space: O(n)
 */
class NumberSmallestUnoccupiedChair {
    data class Friend(val index: Int, val arrival: Int, val leave: Int)
    data class OccupiedChair(val chair: Int, val leave: Int)

    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val friends = mutableListOf<Friend>()
        for (index in times.indices) {
            friends.add(Friend(index, times[index][0], times[index][1]))
        }
        friends.sortWith(compareBy { it.arrival })
        val availableChairs = PriorityQueue<Int>()
        val occupiedChairs = PriorityQueue<OccupiedChair>(compareBy { it.leave })
        var min = 0
        for (friend in friends) {
            while (occupiedChairs.isNotEmpty() && occupiedChairs.peek().leave <= friend.arrival) {
                val leaving = occupiedChairs.poll()
                availableChairs.add(leaving.chair)
            }
            var assigned: Int
            if (availableChairs.isNotEmpty()) {
                assigned = availableChairs.poll()
            } else {
                assigned = min
                min++
            }
            if (friend.index == targetFriend) {
                return assigned
            }
            occupiedChairs.add(OccupiedChair(assigned, friend.leave))
        }
        return -1
    }
}