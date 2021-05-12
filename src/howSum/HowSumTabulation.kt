package howSum

// Given a target number and a list of numbers return a list of numbers that sum up to the target number

fun howSumTabulation(targetSum: Int, numbers: List<Int>, sumMap: MutableMap<Int, MutableList<Int>?> = mutableMapOf()) : MutableList<Int>?{
    if(sumMap.containsKey(targetSum)) return sumMap.getValue(targetSum)
    if(targetSum == 0) return ArrayList()
    if(targetSum < 0) return null

    for(number in numbers){
        val remainder = targetSum - number
        val sumList = howSumTabulation(remainder, numbers, sumMap)
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
    println(howSumTabulation(7, listOf(2, 3)))
    println(howSumTabulation(7, listOf(5, 3, 4, 7)))
    println(howSumTabulation(7, listOf(2, 4)))
    println(howSumTabulation(8, listOf(2, 3, 5)))
    println(howSumTabulation(300, listOf(7, 14)))
}