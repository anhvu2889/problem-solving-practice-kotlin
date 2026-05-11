package topic.greedy

/**
 * 870. Advantage Shuffle
 * Time: O(n * log(n))
 * Space: O(n)
 */
class AdvantageShuffle {
    fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
        val n = nums1.size
        val result = IntArray(n)
        nums1.sort()
        val items = mutableListOf<Item>()
        for (i in nums2.indices) {
            items.add(Item(nums2[i], i))
        }
        items.sortBy { it.value }
        var l = 0
        var r = n - 1
        for (num in nums1) {
            if (num > items[l].value) {
                result[items[l].index] = num
                l++
            } else {
                result[items[r].index] = num
                r--
            }
        }
        return result
    }

    data class Item(val value: Int, val index: Int)
}