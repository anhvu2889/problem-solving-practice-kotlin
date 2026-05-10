package top150.twopointer

/**
 * 11. Container With Most Water
 * Time: O(n)
 * Space: O(1)
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var max = Int.MIN_VALUE
        while (l < r) {
            val d = r - l
            val h = minOf(height[l], height[r])
            max = maxOf(max, d * h)
            if (height[l] >= height[r])
                r--
            else
                l++
        }
        return max
    }
}