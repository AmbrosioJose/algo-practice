package howConstruct

fun howConstructTabulation(target: String, wordBank: List<String>) : MutableList<MutableList<String>> {
    val constructionList : MutableList<MutableList<MutableList<String>>> = MutableList(target.length + 1) { mutableListOf() }

    constructionList[0].add(mutableListOf())
    for(i in 0 ..target.length){
        if(constructionList[i].size != 0){
            for(word in wordBank){
                if( target.substring(i).startsWith(word) ){
                    constructionList[i].forEach(){wordList ->
                        constructionList[word.length + i].add(wordList.toMutableList())
                        constructionList[word.length + i].last().add(word)
                    }
                }
            }
        }
    }

    return constructionList.last()
}

fun main(args: Array<String>){
    println(howConstructTabulation("purple", listOf("purp", "p", "ur", "le", "purpl")))
    println(howConstructTabulation("abcdef", listOf("ab", "abc", "cd", "def", "abcd")))
    println(howConstructTabulation("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar")))
    println(howConstructTabulation("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t")))
//    This will cause a max heap
//    println(howConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee")))
}