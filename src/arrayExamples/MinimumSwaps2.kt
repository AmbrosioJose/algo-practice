package arrayExamples

import java.util.*

class MinimumSwaps2 {
    fun minimumSwaps(arr: Array<Int>): Int {
        var count = 0
        for(i in arr.indices){
            while(i + 1 != arr[i]){
                val swappingPosition = arr[i] - 1
                val tempA = arr[i]
                val tempB = arr[swappingPosition]
                arr[i] = tempB
                arr[swappingPosition] = tempA
                count++
            }
        }
        return count
    }

    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)

        val n = scan.nextLine().trim().toInt()

        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val res = minimumSwaps(arr)

        println(res)
    }

}