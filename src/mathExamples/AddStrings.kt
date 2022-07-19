package mathExamples

class AddStrings {
    /*
    * Time: O(n) n being the largest string. It can be O(1 + n) => O(n)
    *
    * Space: O(n) space to hold the newly created string
    * */
    fun addStrings(num1: String, num2: String): String {
        val builder = StringBuilder()
        var remainder = 0
        var i1 = num1.length - 1; var i2 = num2.length - 1
        while(i1 >= 0 || i2 >= 0){
            var sum = remainder
            if(i1 >= 0)
                sum += num1[i1--] - '0'

            if(i2 >= 0)
                sum += num2[i2--] - '0'

            remainder = sum / 10
            sum %= 10
            // note that the  '0' can be omitted but this is slightly more optimal since it would just be math
            builder.append('0' + sum)
        }

        if(remainder != 0)
            builder.append('0' + remainder)

        return builder.reverse().toString()
    }
}
fun main(){
    val num1 = "11"
    val num2 = "123"

    println(AddStrings().addStrings(num1, num2))
}