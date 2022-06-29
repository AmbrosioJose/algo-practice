package dfsExamples

/*
*
* An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.



Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
*
* */

class Position(r: Int, c: Int){}
class FloodFill {
    // directional vectors
    val rowDirectional = intArrayOf(-1 , 1, 0, 0)
    val columnDirectional = intArrayOf(0, 0, 1, -1)

    fun floodFillImage(image: Array<IntArray>, sr: Int, sc: Int, color: Int) : Array<IntArray>{

        val visited = Array(image.size) {Array<Boolean>(image[0].size){false}}

        visited[sr][sc] = true
        fill4Directionally(image, visited, sr, sc, color)

        return image
    }

    private fun fill4Directionally(image: Array<IntArray>, visited: Array<Array<Boolean>>, sr: Int, sc: Int, color: Int){
        println("Checking row $sr column: $sc")

        for(i in rowDirectional.indices){
            val connectedRowIndex = sr + rowDirectional[i]
            val connectedColumnIndex = sc + columnDirectional[i]

            // Check for out of bounds
            if(connectedRowIndex < 0 || connectedColumnIndex < 0) continue
            if(connectedRowIndex >= image.size || connectedColumnIndex >= image.first().size) continue

            // check visited
            if(visited[connectedRowIndex][connectedColumnIndex]) continue

            visited[connectedRowIndex][connectedColumnIndex] = true

            if(image[connectedRowIndex][connectedColumnIndex] == image[sr][sc])
                fill4Directionally(image, visited, connectedRowIndex, connectedColumnIndex, color)
        }


        image[sr][sc] = color
    }

}

fun main(){
    val image = arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1))
    println(image.contentDeepToString())
    FloodFill().floodFillImage(image, 1, 1, 2)
    print("updated image: ")
    println(image.contentDeepToString())
}