package kthLargestNum

import java.util.PriorityQueue

class MaxHeap {

    // Basic

    // Find a maximum item of a max-heap or a minimum item of a min-heap (aka peek)
    fun findMax(){}

    // Adding a new key to the heap (aka push)
    fun insert(value: Int){}

    // Returns the node of maximum value from a max heap after removing it from the heap (aka pop)
    fun extractMax(): Int { return 0}

    // Removing the root node of a max heap
    fun deleteMax(){}

    // Pop root and push a new key. More efficient than pop followed by push, since only need to balance once, not twice,
    // appropriate for fixed-size heaps
    fun replace(){}

    // Creation

    /// Create an empty heap
    fun createHeap(){}

    /// Create a heap out of given array of elements
    fun heapify(){}

    /// Joining two heaps to form a valid new heap containing all the elements of both, preserving the original heaps
    fun merge(){}

    /// Joining two heaps to form a valid new heap containing all the elements of both, destroying original heaps
    fun meld(){}


    // Inspection

    // Return the number of items in the heap
    fun size(){}

    // Return true if the heap is empty, false otherwise
    fun isEmpty(){}


    // Internal

    // Updating a key within a max- or min- heap, respectively
    fun increaseKey(){}

    // delete an arbitrary node (followed by moving last node and sifting to maintaining heap)
    fun delete(){}

    // Move a node up in the tree, as long as needed; used to restore heap condition after insertion. Called "sift"
    // because node moves up the tree until it reaches the correct level
    fun siftUp(){}

    // Move a node down in the tree, similar to sift up; used to restore heap condition after deletion or replacement
    fun siftDown(){}

}

private fun kthLargestNumber(numbersList: List<Int>, k: Int){
    val numbers: PriorityQueue<Int> = PriorityQueue<Int>()
    numbers.addAll(numbersList)

    print(numbers.peek())
    print(numbers.peek())
    print(numbers.peek())
//    print(numbers.poll())
//    print(numbers.poll())
//    print(numbers.poll())
    print(numbers.elementAt(1))
    print(numbers)

}

fun main(args: Array<String>){
    val numbersList: List<Int> = listOf(11, 3, 2, 1, 15, 5, 4, 45, 88, 9, 50, 45)

    val k: Int = 3

    kthLargestNumber(numbersList, k);

}
