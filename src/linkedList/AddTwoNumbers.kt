package linkedList
class ListNode(var `val`: Int) {
     var next: ListNode? = null
}
class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        sumLists(l1!!, l2!!, 0)
        return l1
    }

    fun sumLists(l1: ListNode, l2: ListNode, remainder: Int){
        var sum = l1.`val` + l2.`val` + remainder
        var newRemainder = 0
        if(sum >= 10){
            newRemainder = 1
            sum -= 10
        }
        l1.`val` = sum

        if(l1.next == null && l2.next == null){
            if(newRemainder > 0)
                l1.next = ListNode(newRemainder)
            return
        }
        else if(l1.next == null || l2.next == null){
            if(newRemainder == 0){
                if(l1.next == null) l1.next = l2.next
                return
            }

            if(l1.next == null)
                l1.next = ListNode(0)
            else
                l2.next = ListNode(0)
        }

        sumLists(l1.next!!, l2.next!!, newRemainder)

    }
}