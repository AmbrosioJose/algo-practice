package mathExamples

import kotlin.math.abs

class Pow {

    /*
    * Time: O(n)
    *
    * Space O(1)
    * */
    fun myPow(x: Double, n: Int): Double {
        if(x == 1.0) return x
        var total =  1.0
        var base = x; var power = n
        var reducer = -1
        if(n < 0){
            println("LESS")
            base = 1 / base
            reducer = 1
        }
        println("base $base power $power")

        while(total != 0.0){
            total *= base
            power += reducer
            println("total $total $power")
        }

        return total
    }

    /*
    * Time O(lgn)
    *
    * Space O(1)
    * */
    fun myPowRecursive(x: Double, n: Int): Double{
        val result = pow(x, n)
        if(n >= 0)
            return result
        return 1 / result
    }

    fun pow(x: Double, n: Int): Double{
        if(x == 0.0) return 0.0
        if(n == 0) return 1.0

        var result = pow(x, n / 2)
        println("result $result n $n squared ${result * result}")
        result *= result
        if(n % 2 == 0)
            return result
        return x * result
    }
}

fun main(){
//    println(Pow().myPowRecursive(2.0, 10))
    println(Pow().myPowRecursive(2.00000, -2147483648))
}