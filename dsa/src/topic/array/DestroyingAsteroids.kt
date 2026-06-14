package topic.array

/**
 * 2126. Destroying Asteroids
 * Time: O(n * log(n))
 * Space: O(1)
 */
class DestroyingAsteroids {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var sum: Long = mass.toLong()
        for (asteroid in asteroids) {
            if (sum < asteroid)
                return false
            sum += asteroid
        }
        return true
    }
}