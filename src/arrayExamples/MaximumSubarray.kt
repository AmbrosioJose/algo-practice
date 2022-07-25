package arrayExamples

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var currentMax = nums[0]
        var max = nums[0]

        for(i in 1 until nums.size){
            println("i $i num")
            currentMax = Math.max(nums[i], nums[i] + currentMax)
            if(max < currentMax)
                max = currentMax
        }

        return max
    }
}

fun main(){
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println(MaximumSubarray().maxSubArray(nums))
}