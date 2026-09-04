package topic.hashmap

/**
 * prefixEnd
 * When receive:
 *  Check to update prefixEnd: only if newId = prefixEnd + 1
 *  Update max: max = maxOf(max, newId)
 *  Duplicate: no ops -> HashSet
 */
class PackageReceiver {

    private val seen = HashSet<Int>()
    private var prefixEnd = -1
    private var max = -1

    fun receivePackage(id: Int) {
        if (!seen.add(id)) {
            return
        }
        max = maxOf(max, id)
        if (prefixEnd + 1 == id) {
            prefixEnd++
        }
    }

    fun query(): Pair<Int, List<Int>> {
        val missing = mutableListOf<Int>()
        for (id in prefixEnd + 1 until max) {
            if (id !in seen) {
                missing.add(id)
            }
        }
        return Pair(prefixEnd, missing)
    }
}