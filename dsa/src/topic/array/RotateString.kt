package topic.array

/**
 * 796. Rotate String
 * Time:
 * Space:
 */
class RotateString {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length)
            return false
        val doubleS = s + s
        return doubleS.contains(goal)
    }
}