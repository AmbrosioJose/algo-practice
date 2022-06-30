package bfsExamples

class Node(var value: Int){
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

class PopulateNextRight {

    fun connect(root: Node?): Node? {
        if(root?.left == null) return root
        connectChildren(root.left!!, root.right!!, root.next)
        return root
    }

    fun connectChildren(leftChild: Node, rightChild: Node, parentNext: Node?){

        leftChild.next = rightChild

        if(parentNext != null)
            rightChild.next = parentNext.left

        if(leftChild.left != null){
            connectChildren(leftChild.left!!, leftChild.right!!, leftChild.next)
            connectChildren(rightChild.left!!, rightChild.right!!, rightChild.next)
        }
    }

}