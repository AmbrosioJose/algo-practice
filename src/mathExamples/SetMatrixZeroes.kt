package mathExamples

class SetMatrixZeroes {

    // Time O(m * n) because we iterate through all values in matrix m x n at most 3 times. Once to save the columns
    // and rows that need to be changed to 0. Then a second or even a third time if all left most columns or top most
    // rows are zero. O(3(m * n)) => O(m*n)

    // Space O(1) because we only use 1 extra variable to keep track of the value in our first value and
    // whether it should be set to 0
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var topRow = matrix[0][0]

        // Save rows and columns that need to be changed to zero to the left and
        // top most rows and columns respectively. [topRow] variable is used to keep
        // track of the top row because the position [0][0]  will be used to keep track
        // of the wether the first column will be changed to zero
        //
        // 1 0 1
        // 1 1 1
        // 1 1 1
        //
        //   |
        //   v
        //
        // topRow |
        //      1   0 1
        //      -------
        //      1 | 1 1
        //      1 | 1 1
        for(i in 0 until matrix.size){
            for(j in 0 until matrix[0].size){
                val value = matrix[i][j]
                if(value == 0){
                    if(i == 0){
                        topRow = 0
                    } else {
                        matrix[i][0] = 0
                    }
                    matrix[0][j] = 0
                }
            }
        }

        matrix.forEach{ row -> println(row.contentToString())}
        println("_______")


        // Set rows to Zero
        for(i in 1 until matrix.size){
            if(matrix[i][0] == 0){
                for(j in 1 until matrix[0].size){
                    matrix[i][j] = 0
                }
            }
        }

        // Set columns to zero
        for(j in 0 until matrix[0].size){
            if(matrix[0][j] == 0){
                for(i in 0 until matrix.size){
                    matrix[i][j] = 0
                }
            }
        }

        if(topRow == 0){
            // set first row to zeroes
            for(j in 0 until matrix[0].size){
                matrix[0][j] = 0
            }
        }

    }
}

//[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// expected [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

//
//  [[-4,-2147483648,6,-7,0],[-8,6,-8,-6,0],[2147483647,2,-9,-6,-10]]
// [[0,0,0,0,0],[0,0,0,0,0],[2147483647,2,-9,-6,0]]

fun main(){
//    val matrix = arrayOf(intArrayOf(0,1,2,0), intArrayOf(3,4,5,2), intArrayOf(1,3,1,5))
    val matrix = arrayOf(intArrayOf(-4,-2147483648,6,-7,0), intArrayOf(-8,6,-8,-6,0), intArrayOf(2147483647,2,-9,-6,-10))
    SetMatrixZeroes().setZeroes(matrix)
    matrix.forEach{ row -> println(row.contentToString())}
}