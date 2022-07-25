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

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged = mutableListOf<IntArray>()
        intervals.sortBy{ a -> a[0]}
        merged.add(intervals.first())

        for(i in 1 until intervals.size){
            if(merged.last()[1] >= intervals[i][0]){
                merged[merged.size - 1][1] = Math.max(merged.last()[1], intervals[i][1])
            } else {
                merged.add(intervals[i])
            }
        }

        return merged.toTypedArray()
    }
}