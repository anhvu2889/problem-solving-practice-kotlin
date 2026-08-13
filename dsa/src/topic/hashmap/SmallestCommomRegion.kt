package topic.hashmap

/**
 * 1257. Smallest Common Region
 * Time: O(n)
 * Space: O(n)
 */
class SmallestCommomRegion {
    fun findSmallestRegion(regions: List<List<String>>, region1: String, region2: String): String {
        val parentMap = HashMap<String, String>()
        for (region in regions) {
            val parent = region[0]
            for (i in 1..<region.size) {
                parentMap[region[i]] = parent
            }
        }
        val ancestors1 = HashSet<String>()
        var ancestor1: String? = region1
        while (ancestor1 != null) {
            ancestors1.add(ancestor1)
            ancestor1 = parentMap[ancestor1]
        }
        var ancestor2: String? = region2
        while (ancestor2 != null) {
            if (ancestors1.contains(ancestor2))
                return ancestor2
            ancestor2 = parentMap[ancestor2]
        }
        return ""
    }
}