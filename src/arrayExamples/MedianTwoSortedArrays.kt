package arrayExamples

class MedianTwoSortedArrays {
}
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val total = nums1.size + nums2.size
    val half = total / 2
    var a = nums1
    var b = nums2
    if(a.size > b.size){
        a = nums2
        b = nums1
    }

    var left = 0
    var right = a.size - 1
    println("total $total half $half")
    while(true){
        val i = (left + right) / 2
        val j = half - i - 2
        println("i $i, j $j")
        val leftA: Int = if(i >= 0) a[i] else Int.MIN_VALUE
        val rightA = if(i + 1 < a.size) a[i + 1] else Int.MAX_VALUE
        val leftB = if(j >= 0) a[j] else Int.MIN_VALUE
        val rightB = if(j + 1 < b.size) b[j + 1] else Int.MAX_VALUE
        println("leftA $leftA, rightA $rightA, leftB $leftB, rightB $rightB,")
        if(leftA <= rightB && leftB <= rightA)
            if((total % 2)== 0){
                return (leftA.coerceAtLeast(leftB) + rightA.coerceAtMost(rightB)) / 2.0
            } else {
                return rightA.coerceAtMost(rightB) + 0.0
            }
        else if(leftA > rightB)
            right = i - 1
        else
            left = i + 1
    }
}

fun main(){
    //[1,3]
    //[2]
    findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))
}