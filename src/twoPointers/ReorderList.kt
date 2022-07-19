package twoPointers

import ListNode
import nodeListOf
import printListNode

class ReorderList {
}

/*
* Time O(n). We go through the entire list Once to find the count O(n). Then we split the  list into 2 which is O(1/2n)
* after that the second half is reversed O(1/2) in total O(n). Then we go through the list a third time to merged the
* now split lists O(n). So in total it is about O(3n) => O(n)
*
* Space O(1) The space is constant because we only use a couple of variables as we do our work
*
* */
fun reorderList(head: ListNode<Int>?): Unit {
    if(head?.next == null) return
    var list1: ListNode<Int>? = head
    var list2: ListNode<Int>? = splitList(head, getMidPosition(head))
    list2 = reverseList(list2!!)
    printListNode(list1)
    printListNode(list2)

    // merge lists
    while(list1 != null && list2 != null){
        val temp = list1.next
        list1.next = list2
        list2 = list2.next
        list1 = list1.next
        list1!!.next = temp
        list1 = list1.next
        println("_")
        printListNode(list1)
        printListNode(list2)
    }
}

fun reverseList(head: ListNode<Int>): ListNode<Int>{
    if(head.next == null) return head

    val newHead = reverseList(head.next!!)
    head.next!!.next = head
    head.next = null
    return newHead
}

fun getMidPosition(head: ListNode<Int>): Int{
    var nodeCount = 1
    var current: ListNode<Int> = head
    while(current.next!= null){
        current = current.next!!
        nodeCount++
    }

    var mid = nodeCount / 2
    if((nodeCount % 2) == 0) mid--
    return mid
}

fun splitList(head: ListNode<Int>?, splitPoint: Int): ListNode<Int> {
    var current = head
    var position = 0
    while(position < splitPoint){
        position++
        current = current!!.next
    }
    val next = current!!.next
    current.next = null
    return next!!
}



fun main(){
    val node1 = nodeListOf(arrayOf(1, 2, 3, 4, 5))
    reorderList(node1)
    printListNode(node1!!)
}