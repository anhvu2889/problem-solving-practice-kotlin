package topic.binarytree

import java.util.*

class NumberLineBlockPlacement {
    fun processOperations(operations: Array<IntArray>): List<Boolean> {
        val ans = ArrayList<Boolean>()
        val blockerSet = TreeSet<Int>()
        for (op in operations) {
            if (op[0] == 0) {
                blockerSet.add(op[1])
            } else {
                ans.add(canPlace(blockerSet, op[1], op[2]))
            }
        }
        return ans
    }

    private fun canPlace(blockerSet: TreeSet<Int>, start: Int, length: Int): Boolean {
        val end = start.toLong() + length - 1
        val next = blockerSet.ceiling(start)
        if (next == null) {
            return true
        }
        return next > end
    }
}