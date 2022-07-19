package heapExamples

import java.util.*

class KthLargest(k: Int, nums: IntArray) {
    val heap = PriorityQueue<Int>(nums.size + 1)
    private val k  = k
    init {
        nums.forEach{ n -> heap.add(n)}

        while(heap.size > k){
            heap.poll()
        }
        println(heap)
    }

    fun add(`val`: Int): Int {
        heap.add(`val`)
        if(heap.size > k)
            heap.poll()
        return heap.peek()
    }

}

fun main(){
    val kthLargest = KthLargest(3, intArrayOf(4,5,8,2))
    println(kthLargest.add(3))
    println(kthLargest.add(5))
    println(kthLargest.add(10))
    println(kthLargest.add(9))
    println(kthLargest.add(4))
}