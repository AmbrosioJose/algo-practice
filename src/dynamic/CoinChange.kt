package dynamic
/*
* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*
* */
class CoinChange {

    fun coinChange(coins: IntArray, amount: Int): Int {
        if(amount == 0) return 0
        val minChange = IntArray(amount + 1) {Int.MAX_VALUE}
        minChange[0] = 0

        for(currentAmount in 1 .. amount){
            coins.forEach{ coin ->
                if(currentAmount >= coin && minChange[currentAmount - coin] != Int.MAX_VALUE){
                    val numCoins = minChange[currentAmount - coin] + 1
                    if(numCoins < minChange[currentAmount]){
                        minChange[currentAmount] = numCoins
                    }
                }
            }
        }
        if(minChange[amount] == Int.MAX_VALUE) return -1
        return minChange[amount]
    }
}