package topic.math

/**
 * 3867. Sum of GCD of Formed Pairs
 * Time: O(n * log(n) + n * log(max(nums)))
 * Space: O(n)
 */
class SumGCDFormedPairs {
    fun gcdSum(nums: IntArray): Long {
        val n = nums.size
        val prefixGcd = IntArray(n)
        var max = nums[0]
        prefixGcd[0] = max
        for (i in 1 until n) {
            max = maxOf(max, nums[i])
            prefixGcd[i] = gcd(nums[i], max)
        }
        var l = 0
        var r = n - 1
        var ans = 0L
        prefixGcd.sort()
        while (l < r) {
            ans += gcd(prefixGcd[l], prefixGcd[r]).toLong()
            l++
            r--
        }
        return ans
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = x % y
            x = y
            y = temp
        }
        return x
    }
}