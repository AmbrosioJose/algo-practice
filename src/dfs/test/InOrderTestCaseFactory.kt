package dfs.test

import dfs.TreeNode
import testFoundations.TestCaseFactoryInterface
import testFoundations.TestCaseInterface

class InOrderTestCaseFactory : TestCaseFactoryInterface<InOrderTraversalTestCase> {
    override fun basicTestCase(): InOrderTraversalTestCase {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        node1.right = node2
        node2.left = node3


        return InOrderTraversalTestCase(
            input = node1,
            expectedResult = listOf(1, 3, 2)
        )
    }

    override fun multipleTestCases(): List<InOrderTraversalTestCase>{
        return listOf(
            basicTestCase(),
            generateTestCase2(),
            generateTestCase3()
            )
    }

    private fun generateTestCase2(): InOrderTraversalTestCase{
        return InOrderTraversalTestCase(
            input = TreeNode(1),
            expectedResult = listOf(1, 3, 2)
        )
    }

    private fun generateTestCase3(): InOrderTraversalTestCase{
        return InOrderTraversalTestCase(
            input = null,
            expectedResult = listOf()
        )
    }


}