package moveZeroes
/*
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
*
* */
class MoveZeroes {
    fun  moveZeroes(nums: IntArray): Unit{
        var offset = 0
        val nonZeroIndexes = IntArray(nums.size)
        nums.forEachIndexed{ i, num ->
            if(num == 0){
                offset++
            } else {
                nonZeroIndexes[i - offset] = i
            }
        }

        nonZeroIndexes.forEachIndexed{i, nonZeroNumIndex ->
            if(i + offset >= nums.size){
                nums[i] = 0
            } else {
                nums[i] = nums[nonZeroNumIndex]
            }
        }




    }

    /// slower but less memory
    fun moveZeroesConstMem(nums: IntArray){
        var lastNonZeroExpectedAt = 0
        for(i in nums.indices){
            if(nums[i] != 0){
                swap(nums, i, lastNonZeroExpectedAt++)
            }
        }

    }

    fun swap(nums: IntArray, index1: Int, index2: Int){
        val temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp
    }
}

fun main(){
    val nums = intArrayOf(0,1,0,3,12)
    MoveZeroes().moveZeroesConstMem(nums)
    println(nums.toList())
}