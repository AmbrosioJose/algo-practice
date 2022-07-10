class ListNode<T>(val value: T) {
    var next: ListNode<T>? = null
}

fun <T> nodeListOf(list: Array<T>): ListNode<T>?{
    if(list.isEmpty()) return null
    val head = ListNode(list.first())
    var current: ListNode<T> = head
    for(i in 1 until list.size){
        current.next = ListNode(list[i])
        current = current.next!!
    }
    return head
}

fun <T> printListNode(node: ListNode<T>?){
    var printingNode = node
    print("[")
    while(printingNode != null){
        print("${printingNode.value}, ")
        printingNode = printingNode.next
    }
    print("]")
    println()
}