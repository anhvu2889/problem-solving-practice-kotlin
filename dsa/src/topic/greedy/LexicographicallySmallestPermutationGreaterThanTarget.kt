package topic.greedy

/**
 * 3720. Lexicographically Smallest Permutation Greater Than Target
 * Time: O(n)
 * Space: O(n)
 */
class LexicographicallySmallestPermutationGreaterThanTarget {
    fun lexGreaterPermutation(s: String, target: String): String {
        val count = count(s)
        val pivot = findPivot(target, count)
        if (pivot == -1) {
            return ""
        }
        return build(s, target, pivot)
    }

    private fun count(s: String): IntArray {
        val count = IntArray(26)
        for (c in s) {
            val code = c - 'a'
            count[code]++
        }
        return count
    }

    private fun findPivot(target: String, count: IntArray): Int {
        var pivot = -1
        for (i in target.indices) {
            val code = target[i] - 'a'
            if (hasGreaterChar(code, count)) {
                pivot = i
            }
            if (count[code] == 0) {
                break
            }
            count[code]--
        }
        return pivot
    }

    private fun hasGreaterChar(code: Int, count: IntArray): Boolean {
        for (i in code + 1..<26) {
            if (count[i] > 0) {
                return true
            }
        }
        return false
    }

    private fun build(s: String, t: String, pivot: Int): String {
        val count = count(s)
        val sb = StringBuilder(s.length)
        for (i in 0..<pivot) {
            val code = t[i] - 'a'
            sb.append(t[i])
            count[code]--
        }
        val pivotCode = t[pivot] - 'a'
        for (i in pivotCode + 1..<26) {
            if (count[i] > 0) {
                sb.append('a' + i)
                count[i]--
                break
            }
        }
        for (i in 0..<26) {
            repeat(count[i]) {
                sb.append('a' + i)
            }
        }
        return sb.toString()
    }
}