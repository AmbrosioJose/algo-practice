package linkedList

import ListNode
import nodeListOf
import printListNode

class RemoveDuplicatesFromSortedList {
}
/*
* Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*
* */

fun deleteDuplicates(head: ListNode<Int>?): ListNode<Int>? {
    if(head?.next == null) return head

    // sentinel value that does not overflow int MIN_VALUE because min value in given listNodes is -100
    val sentinel =  head.value - 1
    return recursiveDeleteDuplicate(head, sentinel)
}

fun recursiveDeleteDuplicate(head: ListNode<Int>?, lastRepeatingValue: Int): ListNode<Int>? {
    if(head?.next == null) return head
    if(head.value == lastRepeatingValue) return recursiveDeleteDuplicate(head.next, lastRepeatingValue)
    if(head.next!!.value == head.value) return recursiveDeleteDuplicate(head.next, head.value)
    head.next = recursiveDeleteDuplicate(head.next, lastRepeatingValue)
    return head
}

fun deleteDuplicateIterative(head: ListNode<Int>?): ListNode<Int>?{
    if(head?.next == null) return head
    val sentinel = ListNode(head.value - 1)
    sentinel.next = head
    var currentNode: ListNode<Int>? = sentinel
    var nextNode: ListNode<Int>?  = head
    while(currentNode != null && nextNode != null){
        if(nextNode.value == nextNode.next?.value){
            val removingValue = nextNode.value
            while(nextNode?.value == removingValue){
                nextNode = nextNode.next
            }
        }
        currentNode.next = nextNode
        currentNode = currentNode.next
        nextNode = nextNode?.next
    }

    return sentinel.next
}

fun main(){
    val head = nodeListOf(arrayOf(1,1,1,2,3,3))
    printListNode(head)
    printListNode(deleteDuplicates(head))
    printListNode(deleteDuplicateIterative(head))
}

