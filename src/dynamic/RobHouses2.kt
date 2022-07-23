package dynamic

class RobHouses2 {

    /*
    * Time: O(n)
    *
    * Space: O(1)
    * */
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) return nums.first()
        return Math.max(robFromUntil(nums, 0, nums.size - 1), robFromUntil(nums, 1, nums.size))
    }


    fun robFromUntil(nums: IntArray, start: Int, end: Int): Int{
        var rob1 = 0
        var rob2 = 0

        for(i in start until end){
            val optionMax = Math.max(rob1 + nums[i], rob2)
            rob1 = rob2
            rob2 = optionMax
        }
        return rob2
    }
}

fun main(){
    println(RobHouses2().rob(intArrayOf(2, 3, 2)))
}