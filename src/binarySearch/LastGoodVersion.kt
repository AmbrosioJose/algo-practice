package binarySearch

class LastGoodVersion(val lastGoodVersion: Int) {
    fun isBadVersion(version: Int): Boolean{
        return version > lastGoodVersion
    }

    fun lastGoodVersion(n: Int): Int{
        var low = 1
        var high = n

        while(low < high){
            val mid = low + (high - low) / 2
            println("low $low mid $mid high $high")
            if(isBadVersion(mid)){
                high = mid
            } else {
                low = mid + 1
            }

        }
        if(isBadVersion(low))
            return low -1
        return low
    }
}

fun main(){
    println(LastGoodVersion(5).lastGoodVersion(5))
}