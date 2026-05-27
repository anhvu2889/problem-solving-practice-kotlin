package topic.graph

/**
 * 1340. Jump Game V
 * Time: O(n * d)
 * Space: O(n)
 */
class JumpGameV {
    fun maxJumps(arr: IntArray, d: Int): Int {
        val n = arr.size
        val dp = IntArray(n)
        var max = 1
        for (i in arr.indices) {
            max = maxOf(max, dfs(i, n, arr, d, dp))
        }
        return max
    }

    fun dfs(i: Int, n: Int, arr: IntArray, d: Int, dp: IntArray): Int {
        if (dp[i] != 0) {
            return dp[i]
        }
        var max = 1
        for (r in i + 1..minOf(i + d, n - 1)) {
            if (arr[r] >= arr[i])
                break
            max = maxOf(max, 1 + dfs(r, n, arr, d, dp))
        }
        for (l in i - 1 downTo maxOf(0, i - d)) {
            if (arr[l] >= arr[i])
                break
            max = maxOf(max, 1 + dfs(l, n, arr, d, dp))
        }
        dp[i] = max
        return max
    }
}