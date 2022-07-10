package mapExamples

class ValidAnagrams {

    // time O(n) space O(n)
    fun areAnagrams(s1: String, s2: String): Boolean {
        if(s1.length != s2.length) return false
        val s1CharMap = HashMap<Char, Int>()
        val s2CharMap = HashMap<Char, Int>()
        for(i in s1.indices){
            s1CharMap[s1[i]] = 1 + s1CharMap.getOrDefault(s1[i], 0)
            s2CharMap[s2[i]] = 1 + s2CharMap.getOrDefault(s2[i], 0)
        }

        // Since we are comparing primitive types the == operator works as expected
        return s1CharMap == s2CharMap
    }

    // time O(nlogn) Space O(n)
    fun subOptimal(s1: String, s2: String) : Boolean{
        if(s1.length != s2.length) return false
        return s1.toSortedSet() == s2.toSortedSet()
    }
}

fun main(){

    println("Are two Strings Anagrams? ")
    println(ValidAnagrams().areAnagrams("test", "estt"))
}