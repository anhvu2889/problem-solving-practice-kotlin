package topic.hashmap

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * Time: O(n)
 * Space: O(1)
 */
class PairsSongsWithTotalDurationsDivisible60 {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        val NUMBER = 60
        val seen = IntArray(NUMBER)
        var ans = 0
        for (i in time.indices) {
            val num = time[i] % NUMBER
            val need = (NUMBER - num) % NUMBER
            ans += seen[need]
            seen[num]++
        }
        return ans
    }
}