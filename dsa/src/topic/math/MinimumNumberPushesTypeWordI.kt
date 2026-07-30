package topic.math

/**
 * 3014. Minimum Number of Pushes to Type Word I
 * Time: O(n)
 * Space: O(1)
 */
class MinimumNumberPushesTypeWordI {
    fun minimumPushes(word: String): Int {
        var totalPush = 0
        var push = 1
        var n = word.length
        while (n > 0) {
            if (n < 8) {
                totalPush += n * push
                break
            } else {
                totalPush += 8 * push
                n -= 8
                push++
            }
        }
        return totalPush
    }
}