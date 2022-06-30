package bfsExamples

import java.util.Collections.min

/*
* Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
* */
class Matrix01 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray>{
        val rows = mat.size
        if(rows == 0) return mat
        val columns = mat.first().size

        
        val dist = Array(rows) {IntArray(columns){Integer.MAX_VALUE - 100000}}

        // Check left and top values

        for(i in mat.indices){
            for(j in mat.first().indices){
                if(mat[i][j] == 0){
                    dist[i][j] = 0
                } else {
                    if(i > 0)
                        dist[i][j] = dist[i][j].coerceAtMost(dist[i - 1][j] + 1)
                    if(j > 0)
                        dist[i][j] = dist[i][j].coerceAtMost(dist[i][j -1] + 1)
                }
            }
        }



        // Check right and bottom values

        for(i in rows - 1 downTo 0){
            for(j in columns - 1 downTo 0){
                if(rows - 1 > i)
                    dist[i][j] = dist[i][j].coerceAtMost(dist[i + 1][j] + 1)
                if(columns - 1 > j)
                    dist[i][j] = dist[i][j].coerceAtMost(dist[i][j + 1] + 1)
            }
        }

        return dist
    }
}