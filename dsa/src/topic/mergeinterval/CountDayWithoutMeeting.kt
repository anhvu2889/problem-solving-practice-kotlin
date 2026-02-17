package topic.mergeinterval

/**
 * 3169. Count Days Without Meetings
 * Time: O(nlog(n))
 * Space: O(1)
 */
class CountDayWithoutMeeting {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        meetings.sortWith(compareBy { it[0] })
        var ocupied = 0
        var start = meetings[0][0]
        var end = meetings[0][1]
        for (meeting in meetings) {
            if (meeting[0] <= end) {
                end = maxOf(end, meeting[1])
            } else {
                ocupied += end - start + 1
                start = meeting[0]
                end = meeting[1]
            }
        }
        ocupied += end - start + 1
        return days - ocupied
    }
}