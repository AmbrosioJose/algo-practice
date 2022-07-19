package stackExamples

class ValidParentheses {
}
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/

fun isValid(s: String): Boolean {
    if(s.length % 2 != 0) return false
    val stack = ArrayDeque<Char>()

    s.forEach{ c ->
        if(isClosingChar(c)){
            if(stack.isEmpty()) return false
            val poppedChar = stack.removeLast()
            if(poppedChar != expectedStart(c)) return false
        } else {
            stack.add(c)
        }
    }
    return stack.isEmpty()
}

fun isClosingChar(c: Char): Boolean{
    if(c == ')' || c == '}' || c == ']') return true
    return false
}

fun expectedStart(closingChar: Char): Char{
    if(closingChar == ')') return '('
    if(closingChar == '}') return '{'
    return '['
}


fun main(){
//    val str = "()"
    val str = "()[]{}"
    println(isValid(str))
}