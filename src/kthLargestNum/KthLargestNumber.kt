package kthLargestNum

import java.util.PriorityQueue

class MaxHeap(capacity: Int) {
    private var size = 0;
    var items: Array<Int?> = arrayOfNulls<Int>(capacity)

    private fun getLeftChildIndex (parentIndex: Int): Int { return 2 * parentIndex + 1}
    private fun getRightChildIndex (parentIndex: Int): Int { return 2 * parentIndex + 2}
    private fun getParentIndex (childIndex: Int): Int { return (childIndex - 1) / 2}

    private fun hasLeftChild(index: Int): Boolean { return getLeftChildIndex(index) < size}
    private fun hasRightChild(index: Int): Boolean { return getRightChildIndex(index) < size}
    private fun hasParent(index: Int): Boolean {return getParentIndex(index) >= 0}

    private fun leftChild(index: Int): Int? {return items[getLeftChildIndex(index)]}
    private fun rightChild(index: Int): Int? {return items[getRightChildIndex(index)]}
    private fun parent(index: Int): Int? {return items[getParentIndex(index)]}

    fun getHeapSize (): Int{ return size }

    private fun swap(indexOne: Int, indexTwo: Int) {
        val numOne: Int? = items[indexOne]
        items[indexOne] = items[indexTwo]
        items[indexTwo] = numOne
    }

    // Ensure Extra capacity (Can be used when the length of table is a variable)
    private fun ensureExtraCapacity(){}

    // peek
    // Returns maximum element
    fun peek(): Int? { return items[0] }

    // poll
    // Returns and deletes the maximum element
    fun poll(): Int? {
        if(size == 0) return null
        val maxNum: Int = items[0]!!
        items[0] = null
        swap(0, size - 1)
        size--
        heapifyDown()
        return maxNum
    }

    // add
    // Add an item from the heap
    fun add(item: Int){
        items[size] = item
        size++
        if(!hasParent(size - 1)) return
        heapifyUp()
    }

    // heapifyUp
    // Move a node up in the tree, as long as needed; used to restore heap condition after insertion.
    // Node moves up the tree until it reaches the correct level
    private fun heapifyUp(){
        var index: Int = size - 1
        while(hasParent(index) && parent(index)!! < items[index]!!){
            swap(getParentIndex(index), index)
            index = getParentIndex(index)
        }
    }

    // heapifyDown
    // Move a node down in the tree, as long as needed; used to restore heap condition after insertion.
    // Node moves down the tree until reaches the correct level
    private fun heapifyDown(){
        var index: Int = 0
        while(hasLeftChild(index)){
            var smallerChildIndex: Int = getLeftChildIndex(index)
            if(hasRightChild(index) && rightChild(index)!! > leftChild(index)!!){
                smallerChildIndex = getRightChildIndex(index)
            }

            if(items[index]!! > items[smallerChildIndex]!!) break

            swap(index, smallerChildIndex)

            index = smallerChildIndex

        }
    }

}

private fun kthLargestNumber(numbersList: List<Int>, k: Int): Int{
    val maxHeap = MaxHeap(numbersList.size)

    numbersList.forEach { number ->
        maxHeap.add(number)
    }
    var kthLargestNum: Int = 0
    for(i in 0 until k) {
        kthLargestNum = maxHeap.poll()!!
        println(" $kthLargestNum")
    }

    return kthLargestNum
}

fun main(args: Array<String>){
    val numbersList: List<Int> = listOf(11, 3, 2, 1, 15, 5, 4, 45, 88, 9, 50, 45)

    val k: Int = 3
   print(kthLargestNumber(numbersList, k))

}
