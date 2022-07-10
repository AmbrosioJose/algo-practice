package listExamples

class SearchInRotatedArray {
    fun search(nums: IntArray, target: Int): Int {
        val pivot = nums.size - findPositionOfSmallest(nums)
        var right = nums.size - 1
        var left = 0
        println("pivot $pivot")
        while(left <= right){
            val mid = (left + (right - left) / 2)
            val adjustedMid = (nums.size + mid - pivot) % nums.size
            if(nums[adjustedMid] == target) return mid
            if(nums[adjustedMid] < target)
                left = mid + 1
            else
                right = mid - 1
        }
        return -1

    }

    fun findPositionOfSmallest(nums: IntArray): Int{
        var right = nums.size - 1
        var left = 0
        while(left < right){
            val mid = left + (right - left) / 2
            if(mid != nums.size - 1  && nums[mid] > nums[mid + 1]) return mid + 1
            if(nums[mid] > nums[0])
                left = mid + 1
            else
                right = mid
        }
        return 0
    }
}

fun main(){
//    println(SearchInRotatedArray().search(intArrayOf(8,9,2,3,4), 9))
    println(SearchInRotatedArray().search(intArrayOf(1), 0))
//    println(SearchInRotatedArray().search(intArrayOf(1, 3), 0))
}

fun firstNonRepeatingCharacter(string: String): Int {
    val characterCountMap = HashMap<Char, Int>()

    var hasRepeating = false
    string.forEachIndexed(){i, char ->
        if(characterCountMap.contains(char)){
            characterCountMap[char] = characterCountMap[char]!! + 1
            hasRepeating = true
        } else {
            characterCountMap[char] = 1
        }
    }

    if(!hasRepeating) return -1


    string.forEachIndexed(){i, char ->
        if(characterCountMap.contains(char) && characterCountMap[char] == 1){
            return i
        }
    }

    return -1


}