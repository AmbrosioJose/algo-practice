package mathExamples

class RotateImage {
    // O(n^2) time because we access every value in the n * n matrix
    // O(1) space because we only use 4 extra variables at a time
    fun rotate(matrix: Array<IntArray>): Unit {
        var left = 0
        var right = matrix.size - 1

        while(left < right){
            for(i in 0 until (right - left)){
                val top = left
                val bottom = right

                // save top left
                val topLeft = matrix[top][left + i]

                // move bottom left into top left
                matrix[top][left + i] = matrix[bottom - i][left]

                // move bottom right into bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i]

                // move top right into bottom right
                matrix[bottom][right - i] = matrix[top + i][right]

                // move top left into top right
                matrix[top + i][right] = topLeft
            }
            left++
            right--
        }
    }
}

fun main(){
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    RotateImage().rotate(matrix)
    matrix.forEach{ row -> println(row.contentToString())}
}