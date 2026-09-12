package topic.hashmap

class HighFive {
    fun highFive(items: Array<IntArray>): Array<IntArray> {
        val MAX_ID = 1000
        val MAX_SCORE = 100
        val AVG_COUNT = 5
        val map = HashMap<Int, MutableList<Int>>()
        val ans = Array(MAX_ID + 1) { IntArray(2) }  // changed
        for (item in items) {
            val id = item[0]  // changed
            val score = item[1]
            map.getOrPut(id) { mutableListOf<Int>() }.add(score)
        }
        for ((id, values) in map) {
            val scores = IntArray(MAX_SCORE + 1)  // changed
            for (value in values) {
                scores[value]++
            }
            var count = 0
            var total = 0
            var found = false
            for (score in MAX_SCORE downTo 0) {
                val freq = scores[score]
                if (freq == 0) {
                    continue
                }
                for (k in 0 until freq) {  // changed
                    total += score
                    count++
                    if (count == AVG_COUNT) {
                        found = true
                        break
                    }
                }
                if (found) {
                    val avg = total / AVG_COUNT
                    ans[id][0] = id
                    ans[id][1] = avg
                    break
                }
            }
        }
        val result = Array(map.size) { IntArray(2) }  // new
        var j = 0  // new
        for (id in 1..MAX_ID) {  // new
            if (ans[id][0] == 0) continue  // new
            result[j] = ans[id]  // new
            j++  // new
        }  // new
        return result  // changed
    }
}
