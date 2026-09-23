package topic.hashmap

/**
 * 1570. Dot Product of Two Sparse Vectors
 */
class DotProductTwoSparseVectors {
    class SparseVector(nums: IntArray) {

        val nonZeroMap: HashMap<Int, Int>

        init {
            nonZeroMap = HashMap<Int, Int>()
            for (i in nums.indices) {
                if (nums[i] == 0) {
                    continue
                }
                nonZeroMap[i] = nums[i]
            }
        }

        // Return the dotProduct of two sparse vectors
        fun dotProduct(vec: SparseVector): Int {
            if (vec.nonZeroMap.size < nonZeroMap.size) {
                return vec.dotProduct(this)
            }
            var sum = 0
            for ((i, value) in nonZeroMap) {
                val vecValue = vec.nonZeroMap[i]
                if (vecValue != null) {
                    sum += value * vecValue
                }
            }
            return sum
        }
    }
}