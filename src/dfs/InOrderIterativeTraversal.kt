package dfs
import java.util.ArrayDeque

class InOrderIterativeTraversal: BinaryTreeInOrderTraversal {
    override fun inOrderTraversal(root: TreeNode?): List<Int>{
        val inOrderList = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()
        var currentNode: TreeNode? = root

        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.push(currentNode)
                currentNode = currentNode.left
            }
            currentNode = stack.pop()
            inOrderList.add(currentNode.value)
            currentNode = currentNode.right
        }
        return inOrderList
    }
}