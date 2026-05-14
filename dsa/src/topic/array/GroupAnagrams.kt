package topic.array

/**
 * 49. Group Anagrams
 * Time: O(n * k)
 * Space: O(n * k)
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for (s in strs) {
            val key = StringBuilder()
            val freq = IntArray(26)
            for (c in s) {
                freq[c - 'a']++
            }
            for (f in freq) {
                key.append('*')
                key.append(f)
            }
            map.getOrPut(key.toString()) { mutableListOf() }.add(s)
        }
        return map.values.toList()
    }
}