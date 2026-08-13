package top150.math

/**
 * 149. Max Points on a Line
 * Time: O(n ^ 2)
 * Space: O(n)
 */
class MaxPointsOnLine {
    fun maxPoints(points: Array<IntArray>): Int {
        val n = points.size
        if (n <= 2) return n

        var best = 1
        for (i in 0 until n) {
            val slopeCount = HashMap<Double, Int>()
            var localMax = 0
            for (j in 0 until n) {
                if (j == i) continue
                val dx = (points[j][0] - points[i][0]).toDouble()
                val dy = (points[j][1] - points[i][1]).toDouble()
                val slope = if (dx == 0.0) Double.POSITIVE_INFINITY else dy / dx + 0.0
                val count = slopeCount.merge(slope, 1, Int::plus)!!
                localMax = maxOf(localMax, count)
            }
            best = maxOf(best, localMax + 1)
        }
        return best
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }

    private fun abs(v: Int): Int = if (v < 0) -v else v
}