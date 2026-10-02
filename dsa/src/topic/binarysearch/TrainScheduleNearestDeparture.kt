package topic.binarysearch

class TrainScheduleNearestDeparture {
    fun minutesSinceLastTrain(departures: List<String>, current: String): Int {
        var l = 0
        var r = departures.size
        while (l < r) {
            val mid = l + (r - l) / 2
            if (compareTime(departures[mid], current) > 0) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        if (l == 0) {
            return compareTime(current, departures[departures.size - 1]) + 24 * 60
        } else {
            return compareTime(current, departures[l - 1])
        }
    }

    private fun compareTime(a: String, b: String): Int {
        val timeA = a.split(":")
        val minuteA = timeA[0].toInt() * 60 + timeA[1].toInt()
        val timeB = b.split(":")
        val minuteB = timeB[0].toInt() * 60 + timeB[1].toInt()
        return minuteA - minuteB
    }
}