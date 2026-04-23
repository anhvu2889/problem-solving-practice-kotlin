package blind75.binarysearch

/**
 * 374. Guess Number Higher or Lower
 * Time: O(log(n)
 * Space: O(1)
 */
class GuessNumberHigherLower {
    fun guess(mid: Int): Int {
        // Dummy fun
        return 0
    }
    fun guessNumber(n: Int): Int {
        var l = 1
        var r = n
        while (l <= r) {
            val mid = l + (r - l) / 2
            when (guess(mid)) {
                0 -> return mid
                -1 -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return -1
    }
}