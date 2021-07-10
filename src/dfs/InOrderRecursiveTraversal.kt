package dfs

class InOrderRecursiveTraversal: BinaryTreeInOrderTraversal{

    override fun inOrderTraversal(root: TreeNode?): List<Int>{
        val inOrderList: MutableList<Int> = mutableListOf<Int>()
        recursiveTraversal(root, inOrderList)
        return inOrderList
    }

    private fun recursiveTraversal(root: TreeNode?, list: MutableList<Int>){
        if(root == null) return

        if(root.left != null) recursiveTraversal(root.left, list)
        list.add(root.value)
        if(root.right != null) recursiveTraversal(root.right, list)
    }

}



fun main(args: Array<String>){
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    node1.right = node2
    node2.left = node3

    val binaryTreeTraversal: BinaryTreeInOrderTraversal = InOrderRecursiveTraversal()

    println(binaryTreeTraversal.inOrderTraversal(node1))
}
