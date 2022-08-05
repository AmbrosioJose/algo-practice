package arrayExamples

/*
*
* O(n) time O(n) space
* example 1
* 10 4
* 2 6 8
* 3 5 7
* 1 8 1
* 5 9 15
*
* example 2
*
* 5 3
* 1 2 100
* 2 5 100
* 3 4 100
*
*
* */
class ArrayManipulation {

/*
 * Complete the 'arrayManipulation' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

    fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
        val results = MutableList<Long>(n){0L}
        var max: Long = 0
        queries.forEach{query ->
            results[query[0] - 1] += query[2].toLong()
            if(query[1] < n){
                results[query[1]] -= query[2].toLong()
            }
        }

        var temp: Long = 0
        for(i in 0 until n){
            temp+=results[i]
            if(temp > max)
                max = temp
        }
        return max
    }

    fun main(args: Array<String>) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

        for (i in 0 until m) {
            queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        }

        val result = arrayManipulation(n, queries)

        println(result)
    }


}