package countConstruct

fun countConstructTabulation(target: String, wordBank: List<String>) : Int {
    val reachableCountList : MutableList<Int> = MutableList(target.length + 1){ 0 }

    reachableCountList[0] = 1

    for(i in 0 ..target.length){
        if(reachableCountList[0] != 0){
            for(word in wordBank){
                if(target.substring(i).startsWith(word)){
                    reachableCountList[i + word.length] += reachableCountList[i]
                }
            }
        }
    }

    return reachableCountList.last()


}

fun main(args: Array<String>){
    println(countConstructTabulation("purple", listOf("purp", "p", "ur", "le", "purpl"))) // 2
    println(countConstructTabulation("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))) // 1
    println(countConstructTabulation("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))) // 0
    println(countConstructTabulation("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))) // 4
    println(countConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee"))) // 0
}