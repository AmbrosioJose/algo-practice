package arrayExamples

class FirstDuplicate {
    fun firstDuplicateValue(array: MutableList<Int>): Int {
        array.forEachIndexed{i, num ->
            val absNum = Math.abs(num)
            val numAtIndex = array[absNum - 1]
            if(numAtIndex >= 0){
                array[absNum - 1] = numAtIndex * -1
            } else{
                return absNum
            }
        }

        return -1
    }
}