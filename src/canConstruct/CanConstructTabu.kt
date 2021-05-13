package canConstruct

fun canConstructTabulation(target: String, wordBank: List<String>) : Boolean {
    val reachableList: MutableList<Boolean> = MutableList(target.length + 1) { false}
    reachableList[0] = true

    for(i in 0 ..target.length){
        if(reachableList[i]){
            for(word in wordBank){
                // check current word matches all of beginning of chunk of target(i to end of target)
                if(target.substring(i).startsWith(word)){
                    reachableList[i + word.length] = true
                }
            }
        }
    }

    return reachableList.last()
}

fun main(args: Array<String>){
    println(canConstructTabulation("abcdef", listOf("ab", "abc", "cd", "def", "abcd")))
    println(canConstructTabulation("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(canConstructTabulation("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t")))
    println(canConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee")))
}