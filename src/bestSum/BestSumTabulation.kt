package bestSum

fun bestSumTabulation(target: Int, numbers: List<Int>): List<Int>?{
    val table: MutableList<MutableList<Int>?> = MutableList(target + 1){ null }

    table[0] = mutableListOf()

    for(i in 0 ..target){
        if(table[i] != null){
            for(num in numbers){
                if((num + i) <= target){
                    // if reachable location is null or there is a shorter  combination available
                    if(table[num + i] == null || table[num + i]!!.size > table[i]!!.size + 1){
                        table[num + i] = table[i]!!.toMutableList()
                        table[num + i]!!.add(num)
                    }
                }
            }
        }
    }

    return table[target]
}

fun main(args: Array<String>){
    println(bestSumTabulation(7, listOf(5, 3, 4, 7)))
    println(bestSumTabulation(8, listOf(2, 3, 5)))
    println(bestSumTabulation(8, listOf(1, 4, 5)))
    println(bestSumTabulation(100, listOf(1, 2, 5, 25)))
}