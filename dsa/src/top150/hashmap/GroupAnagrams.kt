package top150.hashmap

/**
 * 49. Group Anagrams
 * Time: O(n * k)
 * Space: O(n * k)
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for (s in strs) {
            val freq = IntArray(26)
            for (c in s) {
                freq[c - 'a']++
            }
            val key = StringBuilder()
            for (f in freq) {
                key.append(f)
                key.append('#')
            }
            val list = map.getOrDefault(key.toString(), mutableListOf())
            list.add(s)
            map[key.toString()] = list
        }
        return map.values.toList()
    }
}