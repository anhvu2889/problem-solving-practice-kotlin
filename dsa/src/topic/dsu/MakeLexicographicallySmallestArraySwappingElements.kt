package topic.dsu

class MakeLexicographicallySmallestArraySwappingElements {
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val n = nums.size
        val sortedIndexes = nums.indices.sortedBy { nums[it] }
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        buildGroups(sortedIndexes, nums, parent, size, limit)
        val map = HashMap<Int, ArrayDeque<Int>>()
        for (i in sortedIndexes) {
            map.getOrPut(find(i, parent)) { ArrayDeque() }.addLast(nums[i])
        }

        val ans = IntArray(n)
        for (i in 0 until n) {
            val key = find(i, parent)
            val queue = map[key]!!
            ans[i] = queue.removeFirst()
        }
        return ans
    }

    private fun buildGroups(sortedIndexes: List<Int>, nums: IntArray, parent: IntArray, size: IntArray, limit: Int) {
        for (i in 1 until sortedIndexes.size) {
            val a = sortedIndexes[i - 1]
            val b = sortedIndexes[i]
            if (nums[b] - nums[a] <= limit) {
                union(a, b, parent, size)
            }
        }
    }

    private fun find(x: Int, parent: IntArray): Int {
        var root = x
        while (parent[root] != root) {
            root = parent[root]
        }
        var cur = x
        while (cur != root) {
            val temp = parent[cur]
            parent[cur] = root
            cur = temp
        }
        return root
    }

    private fun union(a: Int, b: Int, parent: IntArray, size: IntArray): Boolean {
        var ra = find(a, parent)
        var rb = find(b, parent)
        if (ra == rb) {
            return false
        }
        parent[rb] = ra
        size[ra] += size[rb]
        return true
    }
}