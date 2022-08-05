package linkedList

import java.util.*

class MergeKSortedLists {

    /*
    HEAP
    * Time: O(nlogn) if n is the total numbers nodes.
    *
    *
    * Space: O(n) in worst case there could be a list of 1 Node which means the heap will have a size of n
    * */
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty()) return null
        if(lists.size == 1) return lists.first()
        val heap = PriorityQueue<ListNode>(){ a, b -> a.`val` - b.`val`}
        lists.forEach{ node ->0
            if(node != null)
                heap.add(node)
        }

        val sentinel = ListNode(0)
        var current = sentinel
        while(heap.isNotEmpty()){
            var nextNode = heap.poll()
            current.next = nextNode
            current = current.next!!
            if(nextNode.next != null){
                nextNode = nextNode.next
                heap.add(nextNode)
            }
        }
        return sentinel.next
    }


    /*
    * Divide and conquer
    *
    * */

    fun mergeKListsBetter(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty() ) return null

        var mergedLists: MutableList<ListNode> = mutableListOf()
        lists.forEach{node -> if(node != null) mergedLists.add(node)}

        while(mergedLists.size > 1){
            val currentMerged = mutableListOf<ListNode>()
            for(i in 0..mergedLists.size step 2){
                val l1 = lists[i]
                var l2: ListNode? = null
                    if(i + 1 < mergedLists.size)
                        l2 = lists[i + 1]
                mergedLists.add(merge(l1, l2))
            }
            mergedLists = currentMerged
        }

        return mergedLists.first()
    }

    fun merge(list1: ListNode?, list2: ListNode?): ListNode {
        val sentinel = ListNode(0)
        var tail = sentinel
        var l1 = list1
        var l2 = list2

        while(l1 != null && l2 != null){
            if(l1.`val` > l2.`val`){
                tail.next = l2
                l2 = l2.next
            } else {
                tail.next = l1
                l1 = l1.next
            }
            tail = tail.next!!
        }

        if(l1 != null){
            tail.next = l1
        }
        if(l2 != null){
            tail.next = l2
        }

        return sentinel.next!!
    }
}