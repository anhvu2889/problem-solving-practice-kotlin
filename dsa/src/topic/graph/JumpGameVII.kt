package topic.graph

/**
 * 1871. Jump Game VII
 * Time: O(n)
 * Space: O(n)
 */
class JumpGameVII {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val n = s.length
        val dp = BooleanArray(n)
        dp[0] = true
        var count = 0
        for (i in 1 until n) {
            val l = i - maxJump - 1
            if (l >= 0 && dp[l])
                count--
            val r = i - minJump
            if (r >= 0 && dp[r]) {
                count++
            }
            if (s[i] == '0' && count > 0)
                dp[i] = true
        }
        return dp[n - 1]
    }
}