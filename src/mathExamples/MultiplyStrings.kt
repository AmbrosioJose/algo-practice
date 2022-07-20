package mathExamples

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if("0" in arrayOf(num1, num2)) return "0"

        val n1 = num1.reversed()
        val n2 = num2.reversed()
        var product = IntArray(n1.length + n2.length){0}
        n1.forEachIndexed{ i, m1 ->
            n2.forEachIndexed{ j, m2 ->
                product[i + j] += (m1 - '0') * (m2 - '0')
                product[i + j + 1] += product[i + j] / 10
                product[i + j] %= 10
            }
        }
        var zeroCount = 0
        while(product[product.size - 1 - zeroCount] == 0)
            zeroCount++

        if(zeroCount > 0)
            product = product.sliceArray(0 until product.size - zeroCount)

        val builder = StringBuilder(product.size)
        product.forEach{ n ->
            builder.append(n)
        }
        return builder.reversed().toString()
    }
}

fun main(){
    println(MultiplyStrings().multiply("999", "999"))
}