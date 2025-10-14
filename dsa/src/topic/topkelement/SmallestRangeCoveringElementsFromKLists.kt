package topic.topkelement

import java.util.*

/**
 * 632. Smallest Range Covering Elements from K Lists
 * Time: O(nlog(k))
 * Space: O(k)
 */
class SmallestRangeCoveringElementsFromKLists {
    data class Item(val value: Int, val row: Int, val col: Int)

    fun smallestRange(nums: List<List<Int>>): IntArray {
        var curMax = Int.MIN_VALUE
        val minHeap = PriorityQueue<Item>(compareBy { it.value })
        for (i in nums.indices) {
            val value = nums[i][0]
            minHeap.add(Item(value, i, 0))
            curMax = maxOf(curMax, value)
        }
        var min = minHeap.peek().value
        var max = curMax
        while (true) {
            val top = minHeap.poll() ?: break
            val curMin = top.value
            if (curMax - curMin < max - min || (curMax - curMin == max - min && curMin < min)) {
                min = curMin
                max = curMax
            }
            if (top.col == nums[top.row].size - 1) break
            val nextInRow = Item(nums[top.row][top.col + 1], top.row, top.col + 1)
            minHeap.add(nextInRow)
            curMax = maxOf(nextInRow.value, curMax)
        }
        return intArrayOf(min, max)
    }
}