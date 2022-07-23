package dynamic

class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var totalPalindromes = 0
        for(i in 0 until s.length){
            totalPalindromes += palindromeCountStartingAt(s, i, i)
            if(i + 1 < s.length && s[i + 1] == s[i]){
                totalPalindromes += palindromeCountStartingAt(s, i, i + 1)
            }
        }

        return totalPalindromes
    }

    fun palindromeCountStartingAt(s: String, left: Int, right: Int): Int{
        var l = left; var r = right
        var count = 1
        while(l >= 1 && r + 1 < s.length && s[l - 1] == s[r + 1]){
            l--
            r++
            count++
        }
        return count
    }
}