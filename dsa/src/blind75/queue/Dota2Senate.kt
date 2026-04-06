package blind75.queue

/**
 * 649. Dota2 Senate
 * Time: O(n)
 * Space: O(n)
 */
class Dota2Senate {
    fun predictPartyVictory(senate: String): String {
        val n = senate.length
        val radiant = ArrayDeque<Int>()
        val dire = ArrayDeque<Int>()
        for (i in senate.indices) {
            if (senate[i] == 'D')
                dire.addLast(i)
            else
                radiant.addLast(i)
        }
        while (radiant.isNotEmpty() && dire.isNotEmpty()) {
            val r = radiant.removeFirst()
            val d = dire.removeFirst()
            if (d > r)
                radiant.addLast(r + n)
            else
                dire.addLast(d + n)
        }
        if (radiant.isNotEmpty())
            return "Radiant"
        else
            return "Dire"
    }
}