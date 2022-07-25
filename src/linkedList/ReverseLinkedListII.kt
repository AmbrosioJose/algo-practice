
/*
* Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.



Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]


Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


Follow up: Could you do it in one pass?
* */
class ReverseLinkedListII {
    /*
    * Time:O(n) time since we go through the list once
    *
    * Space: O(1) besides
    * */
    fun reverseBetween(head: ListNode<Int>?, left: Int, right: Int): ListNode<Int>? {
        if(head == null || left == right) return head
        val sentinel = ListNode<Int>(0)
        sentinel.next = head
        var i = 0
        var pointerNode = sentinel
        while(i < left - 1){
            pointerNode = pointerNode.next!!
            i++
        }


        println("${(right - left)} next node ${pointerNode.next!!.value}")
        pointerNode.next =  reverseSublist(pointerNode.next!!, right - left)
        return sentinel.next
    }

    fun reverseSublist(head: ListNode<Int>, remainingLevels: Int): ListNode<Int>{
        if(remainingLevels == 0) return head
        println("node ${head.value} remainingLevels $remainingLevels")
        val newHead = reverseSublist(head.next!!, remainingLevels - 1)
         val newNext = head.next!!.next
        head.next!!.next = head
        head.next = newNext

        return newHead
    }
}

fun main(){
    val node1 = ListNode<Int>(1)
    val node2 = ListNode<Int>(2)
    val node3 = ListNode<Int>(3)
    val node4 = ListNode<Int>(4)
    val node5 = ListNode<Int>(5)
    val node6 = ListNode<Int>(6)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    printListNode(ReverseLinkedListII().reverseBetween(node1, 2, 4))

}