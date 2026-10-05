package topic.hashmap

class BankingSystem {
    fun solution(queries: List<List<String>>): List<String> {
        val balanceMap = HashMap<String, Long>()
        val activityMap = HashMap<String, Long>()
        val ans = ArrayList<String>()

        for (query in queries) {
            val result = when (query[0]) {
                "CREATE" -> create(query[1], balanceMap, activityMap)
                "DEPOSIT" -> deposit(query[1], query[2].toLong(), balanceMap, activityMap)
                "TRANSFER" -> transfer(query[1], query[2], query[3].toLong(), balanceMap, activityMap)
                "TOP" -> top(query[1].toInt(), activityMap)
                else -> ""
            }
            ans.add(result)
        }

        return ans
    }

    private fun create(id: String, balanceMap: HashMap<String, Long>, activityMap: HashMap<String, Long>): String {
        if (balanceMap[id] != null) {
            return "false"
        }
        balanceMap[id] = 0L
        activityMap[id] = 0L
        return "true"
    }

    private fun deposit(
        id: String,
        amount: Long,
        balanceMap: HashMap<String, Long>,
        activityMap: HashMap<String, Long>
    ): String {
        if (balanceMap[id] == null) {
            return "-1"
        }
        val current = balanceMap.getOrDefault(id, 0)
        val updated = current + amount
        balanceMap[id] = updated
        activityMap[id] = activityMap[id]!! + amount
        return updated.toString()
    }

    private fun transfer(
        fromId: String,
        toId: String,
        amount: Long,
        balanceMap: HashMap<String, Long>,
        activityMap: HashMap<String, Long>
    ): String {
        if (balanceMap[fromId] == null || balanceMap[toId] == null) {
            return "-1"
        }
        if (fromId == toId) {
            return "-1"
        }
        if (balanceMap[fromId]!! < amount) {
            return "-1"
        }
        balanceMap[fromId] = balanceMap[fromId]!! - amount
        activityMap[fromId] = activityMap[fromId]!! + amount
        balanceMap[toId] = balanceMap[toId]!! + amount
        activityMap[toId] = activityMap[toId]!! + amount
        return balanceMap[fromId]!!.toString()
    }

    private fun top(n: Int, activityMap: HashMap<String, Long>): String {
        val rankList = ArrayList<Pair<String, Long>>()
        for ((id, activity) in activityMap) {
            rankList.add(Pair(id, activity))
        }
        rankList.sortWith(Comparator() { a, b -> compareRank(a, b) })
        val count = minOf(rankList.size, n)
        val sb = StringBuilder()
        for (i in 0 until count) {
            if (i > 0) {
                sb.append(", ")
            }
            val id = rankList[i].first
            val activity = rankList[i].second
            sb.append("$id($activity)")
        }
        return sb.toString()
    }

    private fun compareRank(a: Pair<String, Long>, b: Pair<String, Long>): Int {
        if (a.second == b.second) {
            return b.first.compareTo(a.first)
        }
        return a.second.compareTo(b.second)
    }
}