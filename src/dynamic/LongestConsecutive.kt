package dynamic

class LongestConsecutive {
    /*
    * Time O(n)
    * Space O(n)
    * */
    fun longestConsecutive(nums: IntArray): Int {
        val groupMap = HashMap<Int,Int>()
        var total = 0

        nums.forEach{ num ->
            groupMap[num] =  1
        }

        val visited = HashSet<Int>()

        nums.forEach{ num ->
            if(!visited.contains(num)){
                // Get child values
                val previousCount = countPrevious(num - 1, groupMap, visited)
                // Update current values
                groupMap[num] = groupMap[num]!! + previousCount
                visited.add(num)

                if(groupMap[num]!! > total)
                    total = groupMap[num]!!
            }
        }

        return total
    }

    fun countPrevious(num: Int, group: HashMap<Int, Int>, visited: HashSet<Int>):Int{
        if(!group.containsKey(num)) return 0
        if(visited.contains(num)) return group[num]!!
        val previous = countPrevious(num - 1, group, visited)

        group[num] = group[num]!! + previous
        visited.add(num)
        return group[num]!!
    }
}