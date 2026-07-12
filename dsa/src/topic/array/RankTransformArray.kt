package topic.array

/**
 * 1331. Rank Transform of an Array
 * Time: O(n * log(n))
 * Space: O(n)
 */
class RankTransformArray {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val sortedArr = arr.sortedArray()
        val map = HashMap<Int, Int>()
        var rank = 0
        for (num in sortedArr) {
            if (map.containsKey(num))
                continue
            rank++
            map[num] = rank
        }
        val ans = IntArray(arr.size)
        for (i in arr.indices) {
            ans[i] = map[arr[i]]!!
        }
        return ans
    }
}