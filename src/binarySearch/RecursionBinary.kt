package binarySearch

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
*/
class RecursionBinary {

    fun search(nums: IntArray, target: Int): Int {
        val low = 0
        val high = nums.size -1

        return searchRecursion(nums, target, low, high)
    }

    private fun searchRecursion(nums: IntArray, target: Int, low: Int,  high: Int): Int{
        val mid: Int = high + low / 2
        println("low $low, mid $mid, high $high")
        if(nums[mid] == target) return mid
        if(low > high) return -1
        if(nums[mid] > target)
            return searchRecursion(nums, target, low, mid - 1)
        return searchRecursion(nums, target, mid + 1, high)
    }

}

fun main(){
    println(RecursionBinary().search(intArrayOf(-1,0,3,5,9,12), -1 ))
}

