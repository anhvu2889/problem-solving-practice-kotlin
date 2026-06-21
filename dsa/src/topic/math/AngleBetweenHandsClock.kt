package topic.math

import kotlin.math.abs

/**
 * 1344. Angle Between Hands of a Clock
 * Time: O(1)
 * Space: O(1)
 */
class AngleBetweenHandsClock {
    fun angleClock(hour: Int, minutes: Int): Double {
        val minAngle = minutes * 6.0
        val hourAngle = 30.0 * (hour + minutes / 60.0)
        val angle = abs(minAngle - hourAngle)
        return minOf(angle, 360.0 - angle)
    }
}