package topic.topkelement

/**
 * 683. K Empty Slots
 * Time: O(n)
 * Space: O(n)
 */
class KEmptySlots {
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val days = IntArray(bulbs.size + 1)
        for (day in bulbs.indices) {
            days[bulbs[day]] = day + 1
        }
        var l = 1
        var r = l + k + 1
        var result = Int.MAX_VALUE
        while (r <= bulbs.size) {
            var valid = true
            var mid = l + 1
            while (mid < r) {
                if (days[mid] < maxOf(days[l], days[r])) {
                    l = mid
                    r = l + k + 1
                    valid = false
                    break
                }
                mid++
            }
            if (valid) {
                result = minOf(result, maxOf(days[l], days[r]))
                l = r
                r = l + k + 1
            }
        }
        return if (result == Int.MAX_VALUE)
            -1
        else
            result
    }
}