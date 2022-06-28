package slidingWindow

class PermutationsInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false
        val s1CharacterMap = HashMap<Char, Int>()
        val windowMap = HashMap<Char, Int>()


        s1.forEachIndexed{ i, c ->
            s1CharacterMap[c] = 1 + s1CharacterMap.getOrElse(c) {0}
            windowMap[s2[i]] = 1 + windowMap.getOrElse(s2[i]) {0}
        }

        if(s1CharacterMap == windowMap) return true

        var leftIndex = 0
        for(rightIndex in s1.length until s2.length){
            windowMap[s2[rightIndex]] = 1 + windowMap.getOrElse(s2[rightIndex]) {0}
            windowMap[s2[leftIndex]] = windowMap[s2[leftIndex]]!! - 1

            if(windowMap[s2[leftIndex]] == 0)
                windowMap.remove(s2[leftIndex])

            leftIndex++
            if(s1CharacterMap == windowMap) return true
        }
        return false

    }
}

fun main(){
    println(PermutationsInString().checkInclusion("ab", "eidbaooo"))
    println(PermutationsInString().checkInclusion("ab", "eidboaoo"))
}