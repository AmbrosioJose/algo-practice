package canSum

fun canSum(target: Int,  numbersList : List<Int>) : Boolean {
    val reachableList : MutableList<Boolean> =  MutableList(target + 1) { false }
    reachableList[0] = true

    for(i in 0 .. target){
        if(reachableList[i]){
            for(num in numbersList){
                if(num + i <= target){
                    reachableList[num + i] = true
                }
            }
        }
    }

    return reachableList[target]
}

fun main(args: Array<String>){
    println(canSum(7, listOf(2, 3)))
    println(canSum(7, listOf(5, 3, 4, 7)))
    println(canSum(7, listOf(2, 5)))
    println(canSum(8, listOf(2, 3, 5)))
    println(canSum(300, listOf(7, 14)))
}