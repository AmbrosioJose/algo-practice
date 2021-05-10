package canSum

/*
*  Given a number and a list of numbers determine whether the target number can be obtained
*  by summing numbers in the list of numbers
*
* */

fun canSum(targetSum: Int, numbers:  List<Int>, sumMap: MutableMap<Int, Boolean> = mutableMapOf() ): Boolean{
    if(sumMap.contains(targetSum) && sumMap[targetSum] != null) return sumMap.getValue(targetSum)
    if(targetSum == 0) return true
    if(targetSum < 0) return false

    for(number in numbers){

        if(number <= targetSum ){
            val remainder = targetSum - number
            if(canSum(remainder, numbers, sumMap)){
                sumMap[targetSum] = true
                return sumMap.getValue(targetSum)
            }
        }
    }

    sumMap[targetSum] = false
    return sumMap.getValue(targetSum)
}

fun main(args: Array<String>){
    println(canSum(7, listOf(2, 3)))
    println(canSum(7, listOf(5, 3, 4, 7)))
    println(canSum(8, listOf(2, 3, 5)))
    println(canSum(300, listOf(7, 14)))
}