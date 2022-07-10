package bfs

class RottingOranges {
    val ROTTEN = 2
    val FRESH = 1
    val EMPTY = 0
    val rowDirectional = intArrayOf(-1, 1, 0, 0)
    val columnDirectional = intArrayOf(0, 0, 1, -1)


    fun findRottingOrangesTime(orangeCrate: Array<IntArray>): Int{
        val rottingOrangesQueue = ArrayDeque<Pair<Int, Int>>()
        var time = 0
        var freshOranges = 0

        // find all rotting oranges
        orangeCrate.forEachIndexed{ i, crateColumn ->
            crateColumn.forEachIndexed{ j, value ->
                if(value == ROTTEN)
                    rottingOrangesQueue.add(Pair(i, j))
                if(value == FRESH)
                    freshOranges++
            }
        }
        println("Rotting oranges ${rottingOrangesQueue.size}")
        println("Fresh oranges $freshOranges")

        if(freshOranges == 0) return time

        while(rottingOrangesQueue.isNotEmpty() && freshOranges > 0){
            var currentLevelCount = rottingOrangesQueue.size
            time++
            println("______")
            println(orangeCrate.contentDeepToString())
            while(currentLevelCount > 0){
                currentLevelCount--
                val rottenOrange = rottingOrangesQueue.removeFirst()
                for(i in rowDirectional.indices){
                    val adjacentValueRow = rottenOrange.first + rowDirectional[i]
                    val adjacentValueColumn = rottenOrange.second + columnDirectional[i]
                    if(adjacentValueRow < 0 || adjacentValueColumn < 0) continue
                    if(adjacentValueRow >= orangeCrate.size || adjacentValueColumn >= orangeCrate.first().size) continue
                    val value = orangeCrate[adjacentValueRow][adjacentValueColumn]
                    if(value == FRESH){
                        orangeCrate[adjacentValueRow][adjacentValueColumn] = ROTTEN
                        freshOranges--
                        rottingOrangesQueue.add(Pair(adjacentValueRow, adjacentValueColumn))
                    }
                }
            }
        }
        if(freshOranges > 0) return -1
        return time
    }
}

fun main(){
//    val allRottenTime = RottingOranges().findRottingOrangesTime(arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)))
    val allRottenTime = RottingOranges().findRottingOrangesTime(arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1)))
    println(allRottenTime)
}