package dynamic

class LongestPalindromic {
    /*
    *
    * Given a string s, return the longest palindromic substring in s.



        Example 1:

        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.
        Example 2:

        Input: s = "cbbd"
        Output: "bb"


        Constraints:

        1 <= s.length <= 1000
        s consist of only digits and English letters.
    * */
    fun longestPalindrome(s: String): String {

        // Iterate through characters
        var i = 0
        var longestPalindrome = ""
        while(i < s.length - longestPalindrome.length / 2){
            // at each character expand outwards to check if there is an odd palindrome
            val palindrome1 = getPalindrome(s, i, i)
            // also check if the number to the right is an even numbered palindrome
            val palindrome2 = getPalindrome(s, i, i + 1)
            // save the longest palindrome so far
            if(palindrome1.length > longestPalindrome.length)
                longestPalindrome = palindrome1
            if(palindrome2.length > longestPalindrome.length)
                longestPalindrome = palindrome2
            i++
        }

        return longestPalindrome
    }

    fun getPalindrome(s: String, l: Int, r: Int): String{
        var left = l; var right = r
        if(right == s.length || s[left] != s[right]) return s[left].toString()
        while(right + 1 <  s.length && left >= 1 && s[left - 1] == s[right + 1]){
            left--
            right++
        }

        val builder = StringBuilder(right - left)
        for(i in left .. right){
            builder.append(s[i])
        }
        return builder.toString()
    }
}

fun main(){
    val s = "abcabdkaa"
    println(LongestPalindromic().longestPalindrome(s))
}