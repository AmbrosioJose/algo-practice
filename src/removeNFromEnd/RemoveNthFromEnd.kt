package removeNFromEnd

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        /// Well be used to Remove the nth from the end.
        // Its goal is to stay n away from right node but not always the case
        // eg: Right most node is 5 in [1, 2, 3, 4, 5], n = 2
        // leftNode will point at 3 ready to remove the 4 or the 2nd from the right
        var leftNode: ListNode = head!!
        /// Used to iterate through the linked list
        var rightNode = head
        var leftPosition = 0
        var count = 0
        // Since we are removing the nth node from the end we need to be a 1 node
        // before that to adjust the next property
        val windowSize = n + 1


        println("windowSize $windowSize")
        while(rightNode != null){
            count++
            rightNode = rightNode.next

            print("$count: ${count - windowSize} > $leftPosition  ${count - windowSize  > leftPosition}")

            if(count - windowSize  > leftPosition){
                leftPosition++
                leftNode = leftNode.next!!
            }
            println(" leftPosition $leftPosition leftNode ${leftNode.`val`}")
        }

        if(n == count) return head.next

        println(leftNode.`val`)
        leftNode.next = leftNode.next!!.next

        return head

    }

    fun simpleRemoveNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var leftNode: ListNode = head!!
        var rightNode = head
        var removingAt = 0
        var count = 0



        while(rightNode != null){
            count++
            rightNode = rightNode.next
        }

        removingAt = count - (n - 1)
        print("count $count removingAt $removingAt ")

        // Removing first case
        if(removingAt == 1){
            return head.next
        }

        // Removing anything but the first
        while(removingAt - 1 != 1){
            leftNode = leftNode.next!!
            removingAt--
        }

        leftNode.next = leftNode.next!!.next

        return head
    }
}

fun main(){
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    val result: ListNode? =  RemoveNthFromEnd().removeNthFromEnd(node1, 3)

    printListNode(result)
}

fun printListNode(node: ListNode?){
    var printingNode = node
    print("[")
    while(printingNode != null){
        print("${printingNode.`val`}, ")
        printingNode = printingNode.next
    }
    print("]")
    println()
}