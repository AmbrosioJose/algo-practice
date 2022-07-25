package intervals

class NonOverlappingIntervals {

    /*
    *
    * Time: 0(nlogn) Even though we pass through the list once O(n) to get the count, we sorted our list which takes O(nlogn)
    *
    * Space: O(1)
    * */
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var removeCount = 0
        intervals.sortBy{i -> i[0]}
        var lastEnd = intervals[0][1]
        for(i in 1 until intervals.size){
            if(areOverlapping(lastEnd, intervals[i])){
                lastEnd = Math.min(lastEnd, intervals[i][1])
                removeCount++
            } else
                lastEnd = intervals[i][1]
        }
        return removeCount
    }

    fun areOverlapping(lastEnd: Int, b: IntArray): Boolean {
        return lastEnd > b[0]
    }
}