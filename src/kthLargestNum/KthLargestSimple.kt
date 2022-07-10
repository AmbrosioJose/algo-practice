package kthLargestNum

import java.util.*

class KthLargestSimple {
    fun findKthLargest(nums: IntArray, k: Int): Int{
        val numsQueue = PriorityQueue<Int>(nums.size){ a, b -> println("$b - $a =  ${b - a}"); b - a}
        nums.forEach{ num ->
            println("Adding $num __________________________")
            numsQueue.add(num)
        }

        var kthLargest = 0
        for(i in 1..k) {
            println("removing ___________________ $i largest")
            kthLargest = numsQueue.poll()
            println("kthLargest $kthLargest")
        }
        return kthLargest
    }
}

fun main(){
    println(KthLargestSimple().findKthLargest(intArrayOf(1, 2, 8, 4, 6, 12, 15, 103, 101, 343), 3))
}