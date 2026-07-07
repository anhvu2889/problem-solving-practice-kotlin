package topic.graph

class MinimumScorePathBetweenTwoCities {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        var ans = Int.MAX_VALUE
        val adjMap = Array(n + 1) { mutableListOf<IntArray>() }
        for (road in roads) {
            val a = road[0]
            val b = road[1]
            val dist = road[2]
            adjMap[a].add(intArrayOf(b, dist))
            adjMap[b].add(intArrayOf(a, dist))
        }
        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(n + 1)
        queue.addLast(1)
        visited[1] = true
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            for (edge in adjMap[cur]) {
                val des = edge[0]
                val dist = edge[1]
                ans = minOf(ans, dist)
                if (visited[des])
                    continue
                queue.addLast(des)
                visited[des] = true
            }
        }
        return ans
    }
}