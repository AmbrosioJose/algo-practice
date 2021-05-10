package howSum

// Given a target number and a list of numbers return a list of numbers that sum up to the target number

fun howSum(targetSum: Int, numbers: List<Int>, sumMap: MutableMap<Int, MutableList<Int>?> = mutableMapOf()) : MutableList<Int>?{
    if(sumMap.containsKey(targetSum)) return sumMap.getValue(targetSum)
    if(targetSum == 0) return ArrayList()
    if(targetSum < 0) return null

    for(number in numbers){
        val remainder = targetSum - number
        val sumList = howSum(remainder, numbers, sumMap)
        if( sumList != null){
            sumList.add(number)
            sumMap[targetSum] = sumList
            return sumMap[targetSum]
        }
    }

    sumMap[targetSum] = null
    return sumMap[targetSum]
}

fun main(args: Array<String>){
    println(howSum(7, listOf(2, 3)))
    println(howSum(7, listOf(5, 3, 4, 7)))
    println(howSum(7, listOf(2, 5)))
    println(howSum(8, listOf(2, 3, 5)))
    println(howSum(300, listOf(7, 14)))
}