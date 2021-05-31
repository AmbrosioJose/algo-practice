import java.lang.Integer.max
import java.lang.Integer.min

/*

There is a one-dimensional garden of length N. In each position of the N length garden, a fountain has been installed.
Given an array a[]such that a[i] describes the coverage limit of ith fountain.
A fountain can cover the range from the position max(i – a[i], 1) to min(i + a[i], N).
In beginning, all the fountains are switched off.
The task is to find the minimum number of fountains needed to be activated such that the whole N-length garden can be covered by water.

Examples:

Input: a[] = {1, 2, 1}
Output: 1
Explanation:
For position 1: a[1] = 1, range = 1 to 2
For position 2: a[2] = 2, range = 1 to 3
For position 3: a[3] = 1, range = 2 to 3
Therefore, the fountain at position a[2] covers the whole garden.
Therefore, the required output is 1.

Input: a[] = {2, 1, 1, 2, 1}
Output: 2

* */

fun minimumFountains(fountains: List<Int>): Int {
    // Used to keep track of the right most fountain reached by the fountain that is at the left most range of the fountain at index i
    val fountainReachList = MutableList(fountains.size) {-1}
    var leftRange = -1
    var rightRange = -1

    for(i in fountains.indices){
        leftRange = max(i - fountains[i], 0)
        rightRange = min(1 + (i + fountains[i]), fountains.size)
        fountainReachList[leftRange] = max(rightRange, fountainReachList[leftRange])
    }
    // Keeps track of number of fountains
    var fountainCount = 1
    // Initiate by setting first fountain that covers left side
    rightRange = fountainReachList[0]

    // Stores index of next fountain needed to be activated
    var updatedRightRange = -1
    for(i in fountains.indices){
        updatedRightRange = max(fountainReachList[i] , updatedRightRange)
        if(i == rightRange){
            fountainCount++
            rightRange = updatedRightRange
        }
    }

    return fountainCount

}

fun main(args: Array<String>){
    val a = listOf<Int>(1, 1, 2, 1, 1)
    print("Minimum fountains: "+ minimumFountains(a))
}
