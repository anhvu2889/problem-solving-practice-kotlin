package top150.dp

/**
 * 70. Climbing Stairs
 * Time: O(n)
 * Space: O(1)
 */
class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        var prior2Steps = 1
        var prior1Steps = 1
        var current = 1
        for (i in 2..n) {
            current = prior1Steps + prior2Steps
            prior2Steps = prior1Steps
            prior1Steps = current
        }
        return current
    }
}