package romanNumeralConvertion.intToRoman

import kotlin.assert

class IntToRoman {
    private val value = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    private val symbol = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

    fun convert(num: Int) : String {
        assert(value.size == symbol.size, lazyMessage =  { "value list size != symbol list size (${value.size} != ${symbol.size})" }  )

        var input = num
        val stringBuilder = StringBuilder()

        var i = 0
        while (input != 0 && i < value.size){
           while(value[i] <= input){
               input -= value[i]
               stringBuilder.append(symbol[i])

           }
            i++
        }

        return stringBuilder.toString()
    }
}