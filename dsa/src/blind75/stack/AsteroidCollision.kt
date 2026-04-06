package blind75.stack

import kotlin.math.abs

/**
 * 735. Asteroid Collision
 * Time: O(n)
 * Space: O(n)
 */
class AsteroidCollision {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val deque = ArrayDeque<Int>()
        for (a in asteroids) {
            var alive = true
            while (alive && deque.isNotEmpty() && deque.last() > 0 && a < 0) {
                if (abs(deque.last()) < abs(a)) {
                    deque.removeLast()
                } else if (abs(deque.last()) == abs(a)) {
                    deque.removeLast()
                    alive = false
                } else {
                    alive = false
                }
            }
            if (alive) deque.addLast(a)
        }
        return deque.toIntArray()
    }
}