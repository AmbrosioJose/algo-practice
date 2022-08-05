package arrayExamples

class MaxPeak {
    fun longestPeak(array: List<Int>): Int {
        var maxPeak = 0

        for(i in 1 until array.size - 1){
            if(isPeak(array, i)){
                val currentPeakSize = getPeakSize(array, i - 1, i + 1)
                if(currentPeakSize > maxPeak)
                    maxPeak = currentPeakSize
            }
        }
        return maxPeak
    }

    fun isPeak(array: List<Int>, i: Int): Boolean{
        return array[i] > array[i - 1] && array[i] > array[i + 1]
    }

    fun getPeakSize(array: List<Int>, l: Int, r: Int): Int{
        var left = l
        var right = r
        while(left - 1 >= 0 && array[left] > array[left - 1])
            left--

        while(right + 1 < array.size && array[right] > array[right + 1])
            right++

        return right - (left - 1)
    }
}