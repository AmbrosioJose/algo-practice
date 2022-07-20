package mathExamples

class PlusOne {
    /*
    * Time: O(n)
    *
    * Space: O(n)
    * */
    fun plusOne(digits: IntArray): IntArray {
        var remainder = 1
        val result = IntArray(digits.size + 1)
        for(i in digits.size - 1 downTo 0){
            var sum = remainder
            sum += digits[i]
            remainder = sum / 10
            sum %= 10
            result[i + 1] = sum
        }
        if(remainder != 0){
            result[0] = remainder
            return result
        }
        return result.sliceArray(1 .. digits.size)
    }
}

fun main(){
    println(PlusOne().plusOne(intArrayOf(1, 2, 3)).contentToString())
}