package slidingWindow

/*
* Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
* */
class LongestSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubstring = 0
        val characterMap = HashMap<Char, Int>()
        val stack = ArrayDeque<Char>()

        s.forEach{ c ->
            if(characterMap.contains(c)){
                do {
                     characterMap.remove(stack.first())
                 } while(stack.removeFirst() != c)
            }

            characterMap[c] = 1
            stack.addLast(c)
            val currentLength = characterMap.size
            if(currentLength > longestSubstring)
                longestSubstring = currentLength
        }
        return longestSubstring
    }

}

fun main(){
    // 3
    println(LongestSubString().lengthOfLongestSubstring("pwwkew"))
}