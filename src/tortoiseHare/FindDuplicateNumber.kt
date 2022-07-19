package tortoiseHare

class FindDuplicateNumber {

    /*
    * Time O(n) time
    *
    * Space O(1) since only 3 variables are used
    * */
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while(slow != fast)

        var slow2 = 0

        do {
            slow = nums[slow]
            slow2 = nums[slow2]
        } while(slow != slow2)

        return slow
    }
}