package topic.slidingwindow

class SymmetricTriplets {
    fun countSymmetricTriplets(s: String): Int {
        var count = 0
        for (i in 0 until s.length - 2) {
            val first = s[i].lowercase()
            val last = s[i + 2].lowercase()
            if (first == last) {
                count++
            }
        }
        return count
    }
}