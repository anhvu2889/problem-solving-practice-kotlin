package topic.slidingwindow

/**
 * 904. Fruit Into Baskets
 * Time: O(n)
 * Space: O(1)
 */
class FruitIntoBasket {
    fun totalFruit(fruits: IntArray): Int {
        var mostConsecutiveStart = 0
        var mostRecentConsecutiveType = fruits[mostConsecutiveStart]
        var otherType = -1
        var w = 1
        var max = 1
        for (i in 1 ..< fruits.size) {
            val currentType = fruits[i]
            if (currentType == mostRecentConsecutiveType) {
                w++
            } else if (currentType == otherType) {
                w++
                otherType = mostRecentConsecutiveType
                mostRecentConsecutiveType = currentType
                mostConsecutiveStart = i
            } else {
                max = maxOf(max, w)
                w = i - mostConsecutiveStart + 1
                otherType = mostRecentConsecutiveType
                mostRecentConsecutiveType = currentType
                mostConsecutiveStart = i
            }
        }
        return maxOf(max, w)
    }
}