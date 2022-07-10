package listExamples

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>>{
        val sums = mutableListOf<List<Int>>()

        val sortedNums = nums.sorted()

        sortedNums.forEachIndexed{ i, num ->
            if(i == 0 || num != sortedNums[i - 1]){
                var left = i + 1
                var right = nums.size - 1
                while(left < right){
                    val sum = sortedNums[i] + sortedNums[left] + sortedNums[right]
                    if(sum == 0) {
                        sums.add(listOf(i, left, right))
                        left++
                        while(left < right && nums[left] == nums[left - 1] )
                            left++
                    } else if(sum > 0){
                        right--
                    } else
                        left++
                }
            }
        }

        return sums
    }
}

fun main(){
    print(ThreeSum().threeSum(intArrayOf(-1,0,1,2,-1,-4)))
}

