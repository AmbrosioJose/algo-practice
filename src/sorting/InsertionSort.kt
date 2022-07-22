package sorting

class InsertionSort {


    /*
    * Time: O(n^2)
    *
    * Space: O(1)
    * */
    fun insertionSort(array: MutableList<Int>): List<Int>{
        for(sortedWindowEnd in 0 until array.size - 1){
            var current = sortedWindowEnd + 1
            while(current > 0 && array[current] < array[current - 1]){
                swap(array, current, current - 1)
                current--
            }
        }
        return array
    }

    fun swap(array: MutableList<Int>, i: Int, j: Int){
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}