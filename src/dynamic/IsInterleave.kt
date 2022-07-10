package dynamic

/*
*
* Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.



Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true


Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
*
* */
class IsInterleave {
}

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if((s1.length + s2.length) != s3.length) return false

    val memo = Array(s1.length){IntArray(s2.length) {-1}}

    return isSuffixInterleave(s1, 0, s2, 0, s3, memo)
}

fun isSuffixInterleave(s1: String, s1Index: Int, s2: String, s2Index: Int, s3: String, memo: Array<IntArray>) : Boolean{
    if(s1Index == s1.length){
        println("index1 Limit s1: $s1Index, s2: $s2Index, ${s2.subSequence(s2Index, s2.length)} == ${s3.subSequence(s1Index + s2Index, s3.length)}")
        return s2.subSequence(s2Index, s2.length) == s3.subSequence(s1Index + s2Index, s3.length)}
    if(s2Index == s2.length){
        println("index1 Limit s1: $s1Index, s2: $s2Index ${s1.subSequence(s1Index, s1.length)} == ${s3.subSequence(s1Index + s2Index, s3.length)}")
        return s1.subSequence(s1Index, s1.length) == s3.subSequence(s1Index + s2Index, s3.length)
    }

    if(memo[s1Index][s2Index] >= 0 ) return memo[s1Index][s2Index] == 1

    var isSuffixValid = false

    if(s3[s1Index + s2Index] == s1[s1Index] && isSuffixInterleave(s1, s1Index + 1, s2, s2Index, s3,  memo) ||
        s3[s1Index + s2Index] == s2[s2Index] && isSuffixInterleave(s1, s1Index, s2, s2Index + 1, s3,  memo)){
        isSuffixValid = true
    }
    memo[s1Index][s2Index] = if(isSuffixValid) 1 else 0
    return isSuffixValid
}

fun main(){
//    println("isInterleave: ${isInterleave("aabcc", "dbbca", "aadbbcbcac")}")

    val isInter = isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
    "babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
    "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb")
    println("isInterleave: $isInter")
}
