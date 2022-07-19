package tortoiseHare

import ListNode

class LinkedListCycle {
}

fun hasCycle(head: ListNode<Int>?): Boolean {
    var slow = head
    var fast: ListNode<Int>? = head

    while(fast?.next != null){
        slow = slow!!.next
        fast = fast.next?.next
        if(slow == fast) return true
    }

    return false

}