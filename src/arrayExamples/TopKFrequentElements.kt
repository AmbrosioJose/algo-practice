package arrayExamples

import java.util.*
import kotlin.collections.HashMap

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if(nums.size == k) return nums
        val frequencyMap = HashMap<Int, Int>()
        // O(n) time
        nums.forEach{num ->
            frequencyMap[num] = 1 + frequencyMap.getOrDefault(num, 0)
        }

        // max heap of Pairs(number, frequency) that uses the frequency as a comparator
        val maxHeap = PriorityQueue<Pair<Int, Int>>{ a, b -> b.second - a.second }

        // Keeping the largest Pair on top takes O(N log k) time. log K to add to the maxHeap, and we do this k times
        // O(N log k) < O(N log k) because if k = N then we just return nums. This means it is slightly better
        // than O(N log N)
        frequencyMap.forEach{ (k, v) ->
            maxHeap.add(Pair<Int,Int>(k, v))
        }

        val result = IntArray(k)

        // When removing k pairs to build our results it takes O(k log k) time. log K to keep the max frequency on top
        // and we do it K times
        for(i in 0 until k){
            result[i] = maxHeap.remove().first
        }

        return result

    }
}