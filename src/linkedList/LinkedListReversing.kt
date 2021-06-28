package linkedList

data class Node<T>(var value: T, var next: Node<T>? = null){
    override fun toString(): String {
        return if(next != null){
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

fun reverseLinkedList(startNode: Node<Int>, prevNode: Node<Int>?) : Node<Int> {
    val nextNode: Node<Int>? = startNode.next
    startNode.next = prevNode
    if(nextNode == null){
        return startNode
    }
    return reverseLinkedList(nextNode, startNode)
}


fun main(args: Array<String>){
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    println(node1)
    val newStartNode = reverseLinkedList(node1, null)
    println(newStartNode)
}