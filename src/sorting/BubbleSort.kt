package sorting

class BubbleSort {

    /*
    * Time: O(n^2) We go through the list n-1 times to place one number in the correct position. The work per pass is
    * n - sortedCount => (n - 1) / 2. So n(n - 1)/ 2 is O(n^2).
    *
    * Space: O(1) if we return the same list
    * */
    fun bubbleSort(array: MutableList<Int>): List<Int> {
        for(sortedPartition in 0 until array.size - 1){
            for(i in 0 until (array.size - 1) - sortedPartition){
                if(array[i] > array[i + 1]){
                    swap(array, i, i + 1)
                }
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