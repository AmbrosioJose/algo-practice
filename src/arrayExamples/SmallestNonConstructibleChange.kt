package arrayExamples

class SmallestNonConstructibleChange {
    fun nonConstructibleChange(coins: MutableList<Int>): Int {
        coins.sort()
        var smallest = 0
        coins.forEach{ coin ->
            if(coin > smallest + 1)
                return smallest + 1
            smallest += coin
        }
        return smallest + 1
    }
}