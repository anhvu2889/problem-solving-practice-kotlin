package blind75.array

/**
 * 605. Can Place Flowers
 * Time: O(n)
 * Space: O(1)
 */
class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var i = 0
        var planted = 0
        while (i < flowerbed.size) {
            if (flowerbed[i] == 0) {
                val left = (i == 0) || flowerbed[i - 1] == 0
                val right = (i == flowerbed.size - 1) || flowerbed[i + 1] == 0
                if (left && right) {
                    planted++
                    flowerbed[i] = 1
                    i += 2
                    continue
                }
            }
            i++
        }
        return planted >= n
    }
}