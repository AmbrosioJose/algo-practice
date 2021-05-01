//Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts. You must make at least one cut. Assume that the length of rope is more than 2 meters.
//Examples:
//
//Input: n = 2
//Output: 1 (Maximum obtainable product is 1*1)
//
//Input: n = 3
//Output: 2 (Maximum obtainable product is 1*2)
//
//Input: n = 4
//Output: 4 (Maximum obtainable product is 2*2)
//
//Input: n = 5
//Output: 6 (Maximum obtainable product is 2*3)
//
//Input: n = 10
//Output: 36 (Maximum obtainable product is 3*3*4)

// recursion tree is more optimal but does solve some problems repeatedly
fun maxProd(input: Int): Int{
    if(input == 0 || input == 1)
        return 0


    var maxValue = 0

    for(i: Int in 1 until input){
        maxValue = maxValue.coerceAtLeast((i * (input - i)).coerceAtLeast(maxProd(input - i) * i))
    }

    return maxValue
}

// dynamic


fun maxProdDyn(input : Int): Int{
    var numsList = MutableList(input + 1) {0}

    for( i in 1 until input + 1){
        var maxValue = 0
        for( j in 1 until  (i/2 + 1)){
            maxValue = maxValue.coerceAtLeast(((i - j )* j).coerceAtLeast(j * numsList[i - j]))
        }
        numsList[i] = maxValue
    }

    return numsList[input]



}

fun main(args: Array<String>){
    print(" max prod ${maxProdDyn(5)}")
}