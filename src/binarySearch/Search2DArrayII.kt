package binarySearch

class Search2DArrayII {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var i = 0
        var j = matrix.first().size - 1

        while(i < matrix.size && j >= 0){
            val value = matrix[i][j]
            if(value == target) return true
            else if(value > target) j--
            else i++
        }
        return false
    }
}

fun main(){
//    println(Search2DArrayII().searchMatrix(arrayOf(intArrayOf(-1)), -5))
//    println(Search2DArrayII().searchMatrix(arrayOf(intArrayOf(-5, -5)), 5))
//    println(Search2DArrayII().searchMatrix(arrayOf(intArrayOf(1, 1)), 2))
//    println(Search2DArrayII().searchMatrix(arrayOf(intArrayOf(1,4,7,11,15), intArrayOf(2,5,8,12,19), intArrayOf(3,6,9,16,22), intArrayOf(10,13,14,17,24), intArrayOf(18,21,23,26,30)), 5))
    println(Search2DArrayII().searchMatrix(arrayOf(intArrayOf(1,2,3,4,5), intArrayOf(6,7,8,9,10), intArrayOf(11,12,13,14,15), intArrayOf(16,17,18,19,20), intArrayOf(21,22,23,24,25)), 5))
//    println(Search2DArrayII().searchMatrix(arrayOf(intArrayOf(1, 4), intArrayOf(2, 5)), 2))
}

//[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
//15