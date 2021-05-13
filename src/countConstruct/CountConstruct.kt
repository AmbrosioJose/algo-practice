package countConstruct// Given a target string and an array of strings find the how many possible different ways the
// target string can be constructed with the array of strings

fun countConstruct(target: String, wordBank: List<String>, map: MutableMap<String, Int> = mutableMapOf()) : Int{
    if(map.containsKey(target)) return map.getValue(target)
    if(target.isEmpty()) return 1
    var count: Int = 0
    for(word in wordBank) {
        if (word.length > target.length) continue
        val subStr: String = target.substring(0, word.length)
        val remaining: String = target.substringAfter(subStr)
        if (subStr == word) {
            val subCount = countConstruct(remaining, wordBank, map)
            count += subCount
        }
    }
    map[target] = count
    return map.getValue(target)

}

fun main(args: Array<String>){
    println(countConstruct("purple", listOf("purp", "p", "ur", "le", "purpl")))
    println(countConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd")))
    println(countConstruct("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(countConstruct("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee")))
}