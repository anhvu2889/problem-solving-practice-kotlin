package topic.greedy

/**
 * 881. Boats to Save People
 * Time: O(nlog(n))
 * Space: O(1)
 */
class BoatsSavePeople {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var l = 0
        var r = people.size - 1
        var boat = 0
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++
            }
            r--
            boat++
        }
        return boat
    }
}