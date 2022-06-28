package middleOfLinkedList

class ListNode(var value: Int){
    var next: ListNode? = null
}

class MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var totalCount = 0
        var middleIndex = 0
        var middleNode = head
        var rightNode = head


        while(rightNode!!.next != null){
            rightNode = rightNode.next
            totalCount++
            if(((totalCount + 1) / 2) > middleIndex){
                middleIndex++
                if(middleNode!!.next != null)
                    middleNode = middleNode.next
            }
        }

        return middleNode
    }
}