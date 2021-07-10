package dfs.test
//
//import dfs.BinaryTreeInOrderTraversal
//import dfs.InOrderRecursiveTraversal
//import dfs.TreeNode
//import org.junit.Test
//import testFoundations.TestCaseInterface
//import java.util.stream.Stream
//import kotlin.test.assertEquals
//
//
//class InOrderTraversalTest {
//
//    @ParameterizedTest
//    @MethodSource
//    fun testRecursiveTraversal(){
//        // Test 1
//        assertEquals(TestCase1().expectedResult, testTraversal(InOrderRecursiveTraversal()))
//
//        // Test 2
//        assertEquals(TestCase2().expectedResult, testTraversal(InOrderRecursiveTraversal()))
//
//        // Test 2
//        assertEquals(TestCase2().expectedResult, testTraversal(InOrderRecursiveTraversal()))
//    }
//
//    private fun testTraversal(treeTraverse: BinaryTreeInOrderTraversal): List<Int>{
//        val root: TreeNode = testTreeData1()
//        return  treeTraverse.inOrderTraversal(root)
//    }
//
//    private fun testCaseProvider() = Stream.of(InOrderTestCaseFactory().multipleTestCases())
//
//
//    private fun testTreeData1(): TreeNode{
//        val node1 = TreeNode(1)
//        val node2 = TreeNode(2)
//        val node3 = TreeNode(3)
//        node1.right = node2
//        node2.left = node3
//        return node1
//    }
//
//
//
//
//}
//
