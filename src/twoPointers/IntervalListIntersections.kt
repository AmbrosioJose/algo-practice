package twoPointers

class IntervalListIntersections {

    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val results = mutableListOf<IntArray>()
        var fIndex = 0
        var sIndex = 0

        while(fIndex < firstList.size && sIndex < secondList.size){
            // if contains add to list
            if(isIntersecting(firstList[fIndex], secondList[sIndex])){
                results.add(intersectingArray(firstList[fIndex], secondList[sIndex]))
            }

            // if both can move forward move smallest otherwise move the one that is available
            if(fIndex < firstList.size - 1 && sIndex < secondList.size - 1)
                if(firstList[fIndex][1] > secondList[sIndex][1])
                    sIndex++
                else
                    fIndex++
            else if(fIndex == firstList.size - 1)
                sIndex++
            else
                fIndex++

        }

        return results.toTypedArray()
    }

    fun intersectingArray(a: IntArray, b: IntArray): IntArray{
        val intersection = IntArray(2)
        intersection[0] = maxOf(a[0], b[0])
        intersection[1] = minOf(a[1], b[1])

        return intersection
    }

    fun isIntersecting(a: IntArray, b: IntArray): Boolean{
        if(a[0] <= b[0] && b[0] <= a[1]) return true
        if(a[0] <= b[1] && b[1] <= a[1]) return true
        if(b[0] <= a[0] && a[0] <= b[1]) return true
        if(b[0] <= a[1] && a[1] <= b[1]) return true
        return false
    }

    /// better solution

    fun intervalIntersectionBetter(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray>{
        val results = mutableListOf<IntArray>()
        var fI = 0
        var sI = 0

        while(fI < firstList.size && sI < secondList.size){

            val low = maxOf(firstList[fI].first(), secondList[sI].first())
            val high = minOf(firstList[fI].last(), secondList[sI].last())

            if(low < high){
                results.add(intArrayOf(low, high))
            }

            if(firstList[fI].last()> secondList[sI].last()){
                sI++
            } else {
                fI++
            }
        }


        return results.toTypedArray()
    }
}

fun main(){
//

//    [[0,2],[5,10],[13,23],[24,25]]
//    [[1,5],[8,12],[15,24],[25,26]]

//    [[1,3],[5,9]]
//    []

    val a = arrayOf<IntArray>(intArrayOf(0,2), intArrayOf(5,10), intArrayOf(13,23), intArrayOf(24,25))
    val b = arrayOf<IntArray>(intArrayOf(1,5), intArrayOf(8,12), intArrayOf(15,24), intArrayOf(25,26))

    println(IntervalListIntersections().intervalIntersectionBetter(a, b).contentDeepToString())
}