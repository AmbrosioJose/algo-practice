package twoPointers

class ValidPalindrome {
}
fun isPalindromeExtraSpace(s: String): Boolean {
    val lowercase: String = s.toLowerCase()
    val builder = StringBuilder()

    lowercase.forEach{ c ->
        if(c in 'a'..'z' || c in '0'..'9'){
            builder.append(c)
        }
    }

    if(builder.length < 2) return true

    val map = HashMap<Char, Int>()
    builder.forEachIndexed{ i, c ->
        if(builder.length / 2 > i){
            map[c] = 1 + map.getOrDefault(c, 0)
        } else {
            if((builder.length / 2) != i || ((builder.length % 2) == 0)){
                if(!map.contains(c)) return false
                map[c] = map[c]!! - 1
                if(map[c] == 0) map.remove(c)
            }
        }
    }
    return true
}

fun isPalindrome(s: String): Boolean {
    val lowercase: String = s.lowercase()
    val builder = StringBuilder()

    lowercase.forEach{ c ->
        if(c in 'a'..'z' || c in '0'..'9'){
            builder.append(c)
        }
    }

    if(builder.length < 2) return true

    var left = 0
    var right = builder.length - 1

    while(left < right){
        println("left ${builder[left]} right ${builder[right]}")
        if(builder[left] != builder[right]) return false
        left++
        right--
    }

    return true
}

fun isPalindromeBetter(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while(left < right){
        if(!s[left].isLetterOrDigit()){
            left++
            continue
        } else if(!s[right].isLetterOrDigit()){
            right--
            continue
        }
        if(s[left].lowercase() != s[right].lowercase()) return false
        left++
        right--
    }
    return true
}

fun main() {
    val str = "A man, a plan, a canal: Panama"
    println(isPalindromeBetter(str))
}