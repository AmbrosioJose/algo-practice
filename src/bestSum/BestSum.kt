package bestSum

// Given the target number and a list of numbers find the smallest list of numbers that sum up
// to the target number. If two are of equal length either is fine

fun bestSum(targetSum: Int, numbers: List<Int>, sumMap: MutableMap<Int, MutableList<Int>?> = mutableMapOf()) : MutableList<Int>?{
    if(sumMap.containsKey(targetSum)) return sumMap.getValue(targetSum)
    if(targetSum == 0) return mutableListOf()
    if(targetSum < 0) return null

    var bestSum: MutableList<Int>? = null
    for(number in numbers){
        val remainder = targetSum - number
        val listSum = bestSum(remainder, numbers, sumMap)
        if(listSum != null){
            // deep copy the list
            val currentList = listSum.toMutableList()
            currentList.add(number)
            if(bestSum == null || bestSum.size > currentList.size){
                bestSum = currentList
            }
        }
    }
    sumMap[targetSum] = bestSum
    return bestSum
}


fun main(args: Array<String>){
    println(bestSum(7, listOf(5, 3, 4, 7)))
    println(bestSum(8, listOf(2, 3, 5)))
    println(bestSum(8, listOf(1, 4, 5)))
    println(bestSum(100, listOf(1, 2, 5, 25)))
}