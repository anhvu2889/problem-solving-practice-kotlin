package topic.twopointer

/**
 * 763. Partition Labels
 * Time: O(n)
 * Space: O(1)
 */
class PartitionLabel {
    fun partitionLabels(s: String): List<Int> {
        val result = mutableListOf<Int>()
        val lastPosMap = IntArray(26)
        for (i in s.indices) {
            lastPosMap[s[i] - 'a'] = i
        }
        var l = 0
        while (l < s.length) {
            var r = lastPosMap[s[l] - 'a']
            var i = l
            while (i <= r) {
                r = maxOf(lastPosMap[s[i] - 'a'], r)
                i++
            }
            result.add(r - l + 1)
            l = r + 1
        }
        return result
    }
}