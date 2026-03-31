package blind75.twopointers

/**
 * 11. Container With Most Water
 * Time: O(n)
 * Space: O(1)
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var max = minOf(height[l], height[r]) * r
        while (l < r){
            if (height[l] < height[r]) {
                l++
            } else {
                r--
            }
            max = maxOf(max, minOf(height[l], height[r]) * (r - l))
        }
        return max
    }
}