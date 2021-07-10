package dfs.test

import dfs.TreeNode
import testFoundations.TestCaseInterface

class InOrderTraversalTestCase(override val expectedResult: List<Int>, override val input: TreeNode?): TestCaseInterface<TreeNode, List<Int>>