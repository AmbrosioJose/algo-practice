package mathExamples

class SpiralMatrix {
    /*
    Time: O(n * m) because we are visiting every single value

    Space: If we count the result O(n) because we are creating a list of size n * m otherwise
    */
    fun spiralOrder(matrix: Array<IntArray>): List<Int>{
        var left = 0
        var right = matrix.first().size - 1
        var top = 0
        var bottom = matrix.size - 1

        val list = MutableList<Int>((right + 1) * (bottom + 1)) {0}
        var listIndex = 0
        while(left <= right && top <= bottom){

            // iterate top
            for(i in left..right){
                list[listIndex] = matrix[top][i]
                listIndex++
            }
            top++

            // iterate right
            for(i in top .. bottom){
                list[listIndex] = matrix[i][right]
                listIndex++
            }
            right--

            if(listIndex >= list.size) break

            // iterate bottom
            println("right $right left $left")
            for(i in right downTo left){
                list[listIndex] = matrix[bottom][i]
                listIndex++
            }
            bottom--

            // iterate left
            for(i in bottom downTo top){
                list[listIndex] = matrix[i][left]
                listIndex++
            }
            left++
        }

        return list.toList()
    }
}

fun main(){
//    val matrix = arrayOf(intArrayOf (1, 2, 3), intArrayOf(10, 11, 4), intArrayOf(9, 12, 5), intArrayOf(8, 7, 6))
//    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(6, 5, 4))

    val matrix = arrayOf(intArrayOf(1,2,3,4),intArrayOf(5,6,7,8),intArrayOf(9,10,11,12))
    println(SpiralMatrix().spiralOrder(matrix))
}