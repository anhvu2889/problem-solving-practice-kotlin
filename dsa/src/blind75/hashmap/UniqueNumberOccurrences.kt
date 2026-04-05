package blind75.hashmap

/**
 * 1207. Unique Number of Occurrences
 * Time: O(n)
 * Space: O(n)
 */
class UniqueNumberOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        for (num in arr) {
            val freq = map.getOrDefault(num, 0)
            map[num] = freq + 1
        }
        val set = map.values.toSet()
        return map.size == set.size
    }
}