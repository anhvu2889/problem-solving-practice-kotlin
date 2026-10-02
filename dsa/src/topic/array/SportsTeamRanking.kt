package topic.array

class SportsTeamRanking {

    fun solution(wins: IntArray, draws: IntArray, scored: IntArray, conceded: IntArray): IntArray {
        val n = wins.size
        if (n == 0) {
            return intArrayOf()
        }
        if (n == 1) {
            return intArrayOf(0)
        }
        val points = LongArray(n)
        val diff = LongArray(n)
        for (i in wins.indices) {
            points[i] = wins[i] * 3L + draws[i]
            diff[i] = scored[i].toLong() - conceded[i]
        }
        val rank = ArrayList<Int>()
        for (i in 0 until n) {
            rank.add(i)
        }
        rank.sortWith { a, b -> compareTeams(a, b, points, diff, scored)}
        return intArrayOf(rank[0], rank[1])
    }

    private fun compareTeams(a: Int, b: Int, points: LongArray, diff: LongArray, scored: IntArray): Int {
        if (points[a] != points[b]) {
            return points[b].compareTo(points[a])
        }
        if (diff[a] != diff[b]) {
            return diff[b].compareTo(diff[a])
        }
        if (scored[a] != scored[b]) {
            return scored[b].compareTo(scored[a])
        }
        return a.compareTo(b)
    }
}