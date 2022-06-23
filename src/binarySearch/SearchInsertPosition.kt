package binarySearch
/*
* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104*/

class SearchInsertPosition {

    fun searchInsert(nums: IntArray, target: Int): Int {
        return searchRecursive(nums, target, 0, nums.size - 1)
    }

    // COULD BE FASTER
    fun searchRecursive(nums: IntArray, target: Int, low: Int, high: Int): Int{
        val mid =  (high + low) / 2
        println("low $low, mid $mid, high $high ")
        if(nums[mid] == target) return mid
        if(low > high){
            if(low == 0) return low
            return high + 1
        }

        if(nums[mid] > target)
            return searchRecursive(nums, target, low, mid - 1)
        return searchRecursive(nums, target, mid + 1, high)
    }
}

fun main(){
    println(SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 0))
}