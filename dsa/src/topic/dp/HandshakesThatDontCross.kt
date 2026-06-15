package topic.dp

/**
 * 1259. Handshakes That Don't Cross
 * Time: O(n)
 * Space: O(n)
 */
class HandshakesThatDontCross {
    fun numberOfWays(numPeople: Int): Int {
        val maxPairs = numPeople / 2
        val dp = LongArray(maxPairs + 1)
        val MOD = 1_000_000_007L
        dp[0] = 1L
        for (totalPairs in 1..maxPairs) {
            for (leftPairs in 0 until totalPairs) {
                val rightPairs = totalPairs - 1 - leftPairs
                dp[totalPairs] = (dp[totalPairs] + (dp[leftPairs] * dp[rightPairs])) % MOD
            }
        }
        return dp[maxPairs].toInt()
    }
}