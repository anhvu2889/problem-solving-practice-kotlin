package blind75.bitmanipulation

/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 * Time: O(log(max(a, b, c)))
 * Space: O(1)
 */
class MinimumFlipsMakeEqual {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var a = a
        var b = b
        var c = c
        var count = 0
        while (a > 0 || b > 0 || c > 0) {
            val aLastBit = a and 1
            val bLastBit = b and 1
            val cLastBit = c and 1
            if (cLastBit == 0) {
                count += aLastBit + bLastBit
            } else if (aLastBit == 0 && bLastBit == 0) {
                count++
            }
            a = a shr 1
            b = b shr 1
            c = c shr 1
        }
        return count
    }
}