package heapSort

// I = Index

// TODO: Test whether a list element is pass by reference
fun swap(numbers: MutableList<Int>, index1: Int, index2: Int){
    val tempValue: Int = numbers[index1]
    numbers[index1] = numbers[index2]
    numbers[index2] = tempValue
}

fun heapify(numbers: MutableList<Int>, heapSize: Int, subTreeRootI: Int){

    var largestValueIndex: Int = subTreeRootI
    val leftIndex: Int = 2 * subTreeRootI + 1
    val rightIndex: Int = 2  * subTreeRootI + 2
    println("heapifying heapSize $heapSize subRootIndex $subTreeRootI")
    println("   ${numbers[largestValueIndex]} ")
    println("${if(leftIndex<heapSize ) numbers[leftIndex] else "  "}      ${if(rightIndex<heapSize ) numbers[rightIndex] else ""}")

    if(leftIndex < heapSize && numbers[leftIndex] > numbers[largestValueIndex])
        largestValueIndex = leftIndex

    if(rightIndex < heapSize && numbers[rightIndex] > numbers[largestValueIndex])
        largestValueIndex = rightIndex

    if(largestValueIndex != subTreeRootI){
        swap(numbers, subTreeRootI, largestValueIndex)
        println("    ${numbers[largestValueIndex]} < ${numbers[subTreeRootI]} after swap = $numbers")

        heapify(numbers, heapSize, largestValueIndex)
    }


}

fun heapSort(numbers : MutableList<Int>){
    println(numbers)

    println("building heap starting from ${numbers.size/2 - 1}")
    // Build heap
    for(i: Int in numbers.size/2 - 1 downTo 0)
        heapify(numbers, numbers.size, i)

    println("Built heap $numbers")

    println("reducing heap")
    // One by one extract an element an element from heap. Move current root to end.
    // Then call max heapify on the reduced heap
    for(i: Int in numbers.size - 1 downTo 1){
        println("i: $i current numbers state: $numbers")
        swap(numbers, 0, i)
        println("After swap $numbers")
        heapify(numbers, i, 0)
        println("____")
    }
}

fun main(args: Array<String>) {
    val numbers: MutableList<Int> = mutableListOf(12, 11, 13, 5, 8, 7)

    heapSort(numbers)

    print("sorted list $numbers")
}