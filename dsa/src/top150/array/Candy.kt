package top150.array

/**
 * 135. Candy
 * Time: O(n)
 * Space: O(n)
 */
class Candy {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        val candies = IntArray(n) { 1 }
        for (i in 1 until n) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1
        }
        for (i in n - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = maxOf(candies[i], candies[i + 1] + 1)
        }
        var sum = 0
        for (candy in candies) {
            sum += candy
        }
        return sum
    }
}