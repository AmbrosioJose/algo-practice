package sorting

class SelectionSort {
    /*
    * Time: O(n^2)
    *
    * Space: O(1) since we return the same array
    * */
    fun selectionSort(array: MutableList<Int>): List<Int> {
        for(minIndex in array.indices)
            for(current in minIndex + 1 until array.size){
                if(array[minIndex] > array[current])
                    swap(array, minIndex, current)
            }
        return array
    }

    fun swap(array: MutableList<Int>, i: Int, j: Int){
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}