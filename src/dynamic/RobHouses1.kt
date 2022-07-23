package dynamic

class RobHouses1 {
    fun rob(nums: IntArray): Int{
        var rob1 = 0
        var rob2 = 0
        nums.forEachIndexed{ _, current ->
            val currentMax = Math.max(rob1 + current, rob2)
            rob1 = rob2
            rob2 = currentMax
        }

        return rob2
    }
}

fun main(){
    println(RobHouses1().rob(intArrayOf(2,7,9,3,1)))
}