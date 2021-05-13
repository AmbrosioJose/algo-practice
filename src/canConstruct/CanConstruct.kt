package canConstruct
fun canConstruct(target: String, wordBank: List<String>, map: MutableMap<String, Boolean> = mutableMapOf()): Boolean{
    if(map.containsKey(target)) return map.getValue(target)
    if(target.isBlank()) return true

    for(word in wordBank){
        if(word.length > target.length) continue
        val subStr : String = target.substring(0, word.length)
        val remainder : String = target.substringAfter(subStr) // probably faster when using index but this is readable
        if(subStr == word && canConstruct(remainder, wordBank, map)){
            println("target $target substr $subStr")
            map[target] = true
            return map.getValue(target)
        }
    }

    map[target] = false
    return  map[target]!!
}

fun main(args: Array<String>){
    println(canConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd")))
    println(canConstruct("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(canConstruct("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee")))
}