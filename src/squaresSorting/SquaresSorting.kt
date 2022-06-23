package squaresSorting
/*
* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
* */
class SquaresSorting {
    fun sortedSquares(nums: IntArray): IntArray{
        val squared = nums.map{ num ->
            num * num
        }
        var left = 0
        var right = nums.size - 1
        val sortedSquared = IntArray(nums.size)
        for(i in nums.size - 1 downTo 0){
            if(squared[left] >  squared[right]){
                sortedSquared[i] = squared[left]
                left++
            } else{
                sortedSquared[i] = squared[right]
                right--
            }
            println(sortedSquared[i])
        }

        return sortedSquared

    }

}

fun main(){
    println(SquaresSorting().sortedSquares(intArrayOf(-1, 0, 4, 10)).asList())
}