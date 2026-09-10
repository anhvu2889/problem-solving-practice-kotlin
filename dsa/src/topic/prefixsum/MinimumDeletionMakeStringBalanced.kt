package topic.prefixsum

/**
 * 1653. Minimum Deletions to Make String Balanced
 * Time: O(n)
 * Space: O(1)
 */
class MinimumDeletionMakeStringBalanced {
    fun minimumDeletions(s: String): Int {
        var cost = 0
        for (c in s) {
            if (c == 'a') {
                cost++
            }
        }
        var min = cost
        for (c in s) {
            cost += if (c == 'b') 1 else -1
            min = minOf(cost, min)
        }
        return min
    }
}