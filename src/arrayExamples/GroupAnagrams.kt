package arrayExamples

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if(strs.isEmpty()) return listOf()
        val resultsMap = HashMap<List<Int>, MutableList<String>>()

        val count = MutableList(26){0}

        strs.forEach{ s ->
            count.fill(0)
            s.forEach{c -> count[c - 'a']++}

            if(!resultsMap.contains(count)) resultsMap[count] = mutableListOf<String>()

            resultsMap[count]!!.add(s)
        }

        return resultsMap.values.map{ v -> v.toList()}

    }
}