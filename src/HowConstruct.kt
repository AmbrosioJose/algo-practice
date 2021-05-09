
fun howConstruct(target: String, wordBank: List<String>, map: MutableMap<String, MutableList<MutableList<String>>> = mutableMapOf()) : MutableList<MutableList<String>>{
    if(map.containsKey(target)) return map.getValue(target)
    if(target.isEmpty()) return mutableListOf(mutableListOf())

    val currentConstruct : MutableList<MutableList<String>> = mutableListOf()
    for(word in wordBank){
        if(word.length > target.length) continue
        val subStr : String = target.substring(0, word.length)
        val remaining: String = target.substringAfter(subStr)
        if(subStr == word){
            val remainingConstruct : MutableList<MutableList<String>> = howConstruct(remaining, wordBank, map)
            for(construct in remainingConstruct){
                construct.add(0, subStr)
                currentConstruct.add(construct)
            }
        }
    }

    map[target] = currentConstruct
    return map.getValue(target)
}

fun main(args: Array<String>){
    println(howConstruct("purple", listOf("purp", "p", "ur", "le", "purpl")))
    println(howConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd")))
    println(howConstruct("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(howConstruct("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(howConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee")))
}