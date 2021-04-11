
/*
The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
Fn = Fn-1 + Fn-2
with seed values
F0 = 0 and F1 = 1.
*/

fun fibonacciNumbers(num: Int): Int {
    if(num <= 1)
        return num
    val fibNums = MutableList<Int>(num + 1) {0}
    fibNums[1] = 1
    for(i in 2 until fibNums.size){
        fibNums[i] = fibNums[i - 1] + fibNums[i - 2]
    }

    return fibNums[num]
}

// space optimized
fun fibOptimized(num: Int): Int{
    if(num <= 1){
        return num
    }
    var a = 0
    var b = 1
    var c = -1

    for(i in 2 until num){
        c = a + b
        a = b
        b = c
    }

    return b
}

fun main(args: Array<String>){
    val fibNum = 9
    print("Fibonacci number($fibNum) " + fibOptimized(fibNum))
}