package top150.array

/**
 * 42. Trapping Rain Water
 * Time:
 * Space:
 */
class TrappingRainWater {
    fun trap(height: IntArray): Int {
        val n = height.size
        var leftMax = 0
        var rightMax = 0
        var water = 0
        var left = 0
        var right = n - 1
        while (left < right) {
            leftMax = maxOf(leftMax, height[left])
            rightMax = maxOf(rightMax, height[right])
            if (leftMax < rightMax) {
                water += leftMax - height[left]
                left++
            } else {
                water += rightMax - height[right]
                right--
            }
        }
        return water
    }
}