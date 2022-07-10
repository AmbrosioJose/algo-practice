package mergeSortedLists

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class MergeSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null) return list2
        if(list2 == null) return list1
        var parent1 = list1
        var parent2 = list2
        if(parent1.`val` > parent2.`val`){
            parent1 = list2
            parent2 = list1
        }
        val merged = parent1
        parent1 = parent1.next
        mergeNodesInto(parent1, parent2, merged)

        return merged
    }

    fun mergeNodesInto(list1: ListNode?, list2: ListNode?, merged: ListNode){
        if(list1 == null && list2 == null) return
        if(list1 == null){
            merged.next = list2
            return
        }
        if(list2 == null){
            merged.next = list1
            return
        }

        if(list1.`val` > list2.`val`){
            merged.next = list2
            mergeNodesInto(list1, list2.next, merged.next!!)
        } else {
            merged.next = list1
            mergeNodesInto(list1.next, list2, merged.next!!)
        }
    }

    fun printNode(node: ListNode){
        print("[ ")
        var iterator: ListNode = node
        while(iterator.next != null){
            print("${iterator.`val`}, ")
            iterator = iterator.next!!
        }
        println("${iterator.`val`} ]")
    }
}

fun listToNode(list: IntArray): ListNode? {
    if(list.isEmpty()) return null
    val parentNode = ListNode(list.first())
    var iteratingNode = parentNode

    for(i in 1 until list.size){
        iteratingNode.next = ListNode(list[i])
        iteratingNode = iteratingNode.next!!
    }
    return parentNode
}



fun main(){
    val node1 = listToNode(intArrayOf(1, 2, 4))
    val node2 = listToNode(intArrayOf(1, 3, 4))
    val c = MergeSortedLists()

    c.printNode(c.mergeTwoLists(node1, node2)!!)


}