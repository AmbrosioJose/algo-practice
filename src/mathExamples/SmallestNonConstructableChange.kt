package mathExamples

class SmallestNonConstructableChange {
    /*
    * Time: nlogn because we sort the coins first.
    *
    * Space: O(1)
    *
    *
    * Explanation starting at 1 if the difference between the current coin and the previous coin is larger than
    * 1 than the smallest coin we can't construct previous coin + 1. At every point we have the largest number that we
    * can construct. If the number after that is larger by more than 1 then the smallest number that we can't construct is the largest so far plus 1
    * eg: are largest is 100 and we haven't found a smallest number that isn't constructable and the next number is 110
    *  then smallest number we can't construct is 101
    *  eg: coins  [1, 2, 3, 7, 15]
    *      largest 1  3  6  13
    *       notice that at 3 the largest number we can construct is 6(6{3 + 2 + 1}, 5{3 + 2}, 4{3 + 1}, 3{3} 2{2}, 1{1}).
    *       You can do the same for 7 when the largest number that can be made is 13. Since the next number is 15, 15 is
    *       too large to make 14 and the sum of all previous numbers is at max 13 so it can't make 14 meaning that the
    *       smallest number that can't be made is 14 or 13 + 1
    * */
    fun nonConstructibleChange(coins: MutableList<Int>): Int {
        coins.sort()
        var largestConstructable = 0
        coins.forEach{ coin ->
            if(coin > largestConstructable + 1)
                return largestConstructable + 1
            largestConstructable += coin

        }
        return largestConstructable + 1
    }
}