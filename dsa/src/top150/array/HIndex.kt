package top150.array

/**
 * 274. H-Index
 * Time: O(n)
 * Space: O(n)
 */
class HIndex {
    fun hIndex(citations: IntArray): Int {
        val n = citations.size
        val count = IntArray(n + 1)
        for (citation in citations) {
            if (citation < n) {
                count[citation]++
            } else {
                count[n]++
            }
        }
        var papers = 0
        for ( i in n downTo 0) {
            papers += count[i]
            if (papers >= i)
                return i
        }
        return 0
    }
}