package dfsExamples
/*You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/
class MaxAreaOfIsland {
    val rowDirectional = intArrayOf(-1, 1, 0, 0)
    val columnDirectional = intArrayOf(0, 0, 1, -1)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val visited = Array(grid.size){Array(grid.first().size){false}}
        var maximumArea = 0

        grid.forEachIndexed{ r, column ->
            column.forEachIndexed{ c, gridValue ->
                if(!visited[r][c] && gridValue == 1){
                    visited[r][c] = true
                    val areaOfCurrentIsland = islandAreaAt(grid, visited, r, c)
                    if(areaOfCurrentIsland > maximumArea)
                        maximumArea = areaOfCurrentIsland
                }
            }
        }

        return maximumArea
    }

    private fun islandAreaAt(grid: Array<IntArray>, visited: Array<Array<Boolean>>, r: Int, c: Int) : Int{
        var area = 1

        // get area of connected land
        for(i in rowDirectional.indices){
            val connectedR = r + rowDirectional[i]
            val connectedC = c + columnDirectional[i]

            // Skip out of bounds
            if(connectedR < 0 || connectedC < 0) continue
            if(connectedR >= grid.size || connectedC >= grid.first().size) continue

            // Skip already visited
            if(visited[connectedR][connectedC]) continue
            visited[connectedR][connectedC] = true

            // Skip water areas
            if(grid[connectedR][connectedC] == 0) continue

            area += islandAreaAt(grid, visited, connectedR, connectedC)
        }


        return area
    }
}