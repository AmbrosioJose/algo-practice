package mapExamples
/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/
class FindAnagrams {

    /*
    * Time: O(n). size of s >= size of p. Initializing or maps takes O(p) at most O(s).
    *   the sliding window goes through the string s once but at each point we compare our maps which will be at most 26
    *   times since the characters in p and s are only lowercase letters(26). We slide our window (size of s - size of p) times but the difference is a relatively constant, so we can say we fo through it O(s).
    *   At every slide we compare at worst case 26 times. So going through our window is about O(26s) which is O(n).
    *   Updating values and removing from our windowMap is constant so it adds in worst case O(2s) work which leads to O(28s) which is O(n)
    *
    *
    *  Space: We use two maps at most size of 26, a list of at most length of s, and 2 pointer integers. The largest
    *   possible space complexity would be the list of our results of size, length of s. O(s) => O(n).
    *   If the size of our results is not included in our space complexity then at the second largest space that we
    *   use are the maps each has at most a size of 26 O(26) which is basically constant. O(1)
    *
    *
    * */
    fun findAnagrams(s: String, p: String): List<Int>{
        if(p.length > s.length) return listOf()
        val results = mutableListOf<Int>()
        var windowStart = 0
        var windowEnd = p.length - 1
        val windowMap = HashMap<Char, Int>()
        val pMap = HashMap<Char, Int>()

        p.forEachIndexed{i, c ->
            pMap[c] = 1 + pMap.getOrDefault(c, 0)
            windowMap[s[i]] = 1 + windowMap.getOrDefault(s[i], 0)
        }

        while(windowEnd < s.length){
            if(windowMap == pMap){
                results.add(windowStart)
            }

            val currentStartingChar = s[windowStart]
            windowMap[currentStartingChar] = windowMap[currentStartingChar]!! - 1
            if(windowMap[currentStartingChar] == 0) windowMap.remove(currentStartingChar)

            windowStart++
            windowEnd++
            if(windowEnd < s.length){
                windowMap[s[windowEnd]] = 1 + windowMap.getOrDefault(s[windowEnd], 0)
            }
        }

        return results.toList()
    }

}