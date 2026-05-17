package top150.hashmap

/**
 * 205. Isomorphic Strings
 * Time: O(n)
 * Space: O(1)
 */
class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length)
            return false
        val sMap = IntArray(128) { -1 }
        val tMap = IntArray(128) { -1 }
        for (i in s.indices) {
            val sCode = s[i].code
            val tCode = t[i].code
            if (sMap[sCode] != -1 && sMap[sCode] != tCode)
                return false
            if (tMap[tCode] != -1 && tMap[tCode] != sCode)
                return false
            sMap[sCode] = tCode
            tMap[tCode] = sCode
        }
        return true
    }
}