package blind75.array

/**
 * 1431. Kids With the Greatest Number of Candies
 * Time: O(n)
 * Space: O(1)
 */
class KidsWithGreatestNumberCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        var max = Int.MIN_VALUE
        for (c in candies)
            max = maxOf(max, c)
        val result = mutableListOf<Boolean>()
        for (c in candies) {
            result.add(c + extraCandies >= max)
        }
        return result
    }
}