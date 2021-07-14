package mergeIntervals

class MergeIntervals {
    fun mergeLists(list: Array<Array<Int>>): Array<Array<Int>>{
        list.sortBy{ innerList -> innerList[0] }
        val mergedList = mutableListOf<Array<Int>>()
        var startPosition = -1

        for(i in list.indices){
            if(startPosition < 0) startPosition = i
            if(i != list.size - 1 && canMergeNext(list, i)){
                continue
            } else {
                mergedList.add(arrayOf(list[startPosition][0], list[i][1]))
                startPosition = -1
            }
        }
        print(mergedList)
        return mergedList.toTypedArray()
    }

    private fun canMergeNext(list: Array<Array<Int>>, currentPosition: Int): Boolean {
        return list[currentPosition][1] == list[currentPosition + 1][0]
    }
}