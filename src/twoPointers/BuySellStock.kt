package twoPointers

class BuySellStock {
    /*
    * Time: O(n)
    *
    * Space: O(1)
    *
    * */
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for(i in 0 until prices.size){
            if(prices[i] < minPrice)
                minPrice = prices[i]
            else if(prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice
        }

        return maxProfit
    }

    /*
    * Time: O(n)
    *
    * Space: O(1)
    *
    * */
    fun maxProfit2(prices: IntArray): Int{
        var left = 0
        var right = 1
        var maxProfit = 0
        while(right < prices.size){
            if(prices[right] > prices[left]){
                val profit = prices[right] - prices[left]
                maxProfit = Math.max(maxProfit, profit)
            } else
                left = right
            right++
        }

        return maxProfit
    }
}

fun main(){
    println(BuySellStock().maxProfit2(intArrayOf(7,1,5,3,6,4)))
}