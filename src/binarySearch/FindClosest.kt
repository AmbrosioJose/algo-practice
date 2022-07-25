package binarySearch

class FindClosest {
    open class BST(value: Int) {
        var value = value
        var left: BST? = null
        var right: BST? = null
    }

    fun findClosestValueInBst(tree: BST, target: Int): Int {
        if(tree.left == null && tree.right == null || tree.value == target) return tree.value
        if(tree.value > target){
            if(tree.left == null)
                return tree.value
            else {
                val smaller = findClosestValueInBst(tree.left!!, target)
                if(Math.abs(target - smaller) >= Math.abs(target - tree.value)){
                    return tree.value
                }
                return smaller
            }
        }

        if(tree.right == null)
            return tree.value
        val larger = findClosestValueInBst(tree.right!!, target)
        if(Math.abs(target - larger) >= Math.abs(target - tree.value)){
            return tree.value
        }
        return larger

    }

}