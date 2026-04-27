package blind75.dp

/**
 * 790. Domino and Tromino Tiling
 * Time: O(n)
 * Space: O(1)
 */
class DominoTrominoTiling {
    fun numTilings(n: Int): Int {
        if (n <= 1)
            return 1
        if (n == 2)
            return 2
        var prevFull2 = 1L
        var prevFull1 = 2L
        var prevPartial = 1L
        val mod = 1_000_000_007L
        for (i in 3..n) {
            val curFull = (prevFull1 + prevFull2 + 2L * prevPartial) % mod
            val curPartial = (prevPartial + prevFull2) % mod
            prevFull2 = prevFull1
            prevFull1 = curFull
            prevPartial = curPartial
        }
        return prevFull1.toInt()
    }
}