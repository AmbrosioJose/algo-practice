package arrayExamples

/*
Given a sorted array of integers arr and an integer target, find the
index of the first and last position of target in arr. If target can't be
found in arr, return [-1, -1]
*/

class FirstAndLastIndex {
    /// nlogn
    fun indexSpan(target: Int, nums: IntArray) : IntArray{
        var startIndex = -1
        var endIndex = -1

        for(i in nums.indices){
            if(nums[i] == target){
                if(startIndex < 0)
                    startIndex = i
                endIndex = i
            } else {
                if(endIndex >= 0)
                    return intArrayOf(startIndex, endIndex)
            }
        }
        return intArrayOf(startIndex, endIndex)
    }

    fun binaryIndexSpan(target: Int, s: IntArray): IntArray {
        var startIndex: Int
        var endIndex: Int

        val foundAtIndex: Int = binarySearch(target, s);
        startIndex = foundAtIndex
        endIndex = foundAtIndex

        if(foundAtIndex < 0) return intArrayOf(-1, -1)

        while(startIndex - 1 >= 0 && target == s[startIndex -1]){
            startIndex--
        }

        while(endIndex + 1 < s.size && target == s[endIndex + 1]){
            endIndex++
        }


        return intArrayOf(startIndex, endIndex)
    }

    // Returns -1 if target isn't found
    private fun binarySearch(target: Int, s: IntArray): Int{
        var left = 0
        var right = s.size - 1

        while(left <= right){
            val mid = left + (right - left) / 2
            if(s[mid] == target) return mid

            if(s[mid] > target){
                right = mid - 1
            } else
                left = mid + 1
        }
        return -1
    }

    fun binaryFirstLast(target: Int, s: IntArray) : IntArray {
        val start = findStart(target, s)
        val end = findEnd(target, s)

        return intArrayOf(start, end)
    }

    fun findStart(target: Int, s: IntArray) : Int{
        var left = 0
        var right = s.size - 1
        while(left <= right){
            val mid = left + (right - left) / 2
            if(s[mid] == target && (mid == 0 || s[mid - 1] < target)) return mid

            if(s[mid] >= target) right = mid -1
            else left = mid + 1
        }
        return -1
    }

    fun findEnd(target: Int, s: IntArray): Int{
        var left = 0
        var right = s.size - 1

        while(left <= right){
            val mid = left + (right - left) / 2
            if(s[mid] == target && (mid == s.size - 1 || s[mid + 1] > target)) return mid

            if(s[mid] >= target) right = mid - 1
            else left = mid + 1
        }
        return -1
    }


}

fun main(){
    println(FirstAndLastIndex().binaryFirstLast(5, intArrayOf(1, 2, 3, 4, 4, 4, 5, 5, 8, 9, 10, 11, 12, 13, 15)).toList())
}