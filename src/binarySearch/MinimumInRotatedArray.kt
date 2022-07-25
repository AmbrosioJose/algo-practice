package binarySearch

class MinimumInRotatedArray {
    fun findMin(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]
        var left = 0
        var right = nums.size - 1

        if(nums[right] > nums[left]) return nums[left]

        while(left <= right){
            val mid = left + (right - left) / 2

            println("mid num ${nums[mid]}")
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1]
            if(nums[mid - 1] > nums[mid]) return nums[mid]

            if(nums[0] > nums[mid]){
                right = mid - 1
            } else {
                left = mid + 1
            }

        }

        return -1
    }
}

fun main(){
    val list1 = intArrayOf(11,13,15,17)
    val list2 = intArrayOf(3,4,5,1,2)
    val list3 = intArrayOf(4,5,6,7,0,1,2)
    val list4 = intArrayOf(4,5,6,7,8,0,1,2)

    println(MinimumInRotatedArray().findMin(list4))
}