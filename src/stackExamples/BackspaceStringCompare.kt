package stackExamples

class BackspaceStringCompare {

    /*
    * Time: O(n) for Each String we create and pop for a stack taking in worst case O(2n) then we joinToString which
    * takes O(n) time since it is using a string builder on a StringBuilder so Each String does O(3n) time which then is
    * O(6n) => O(n)
    *
    * Space: Since we create two Strings and two stacks of at most size n each. O(n)
    *
    * Note: There is a more space optimal way by using two pointers. One pointer starting on the end of each String/.
    * */
    fun backspaceCompare(s: String, t: String):Boolean{
        if(s.isEmpty() && t.isEmpty()) return true
        return removeBackSpaces(s) == removeBackSpaces(t)
    }
    fun removeBackSpaces(s: String): String{
        val stack = ArrayDeque<Char>()
        s.forEach{ c->
            if(c != '#'){
                stack.add(c)
            } else if(stack.isNotEmpty()){
                stack.removeLast()
            }
        }
        return stack.joinToString()
    }
}

fun main(){
    val s1 = "ab#c"
    val s2 = "ad#c"

//    val s1 = "bb#c"
//    val s2 = "ad#c"

//    val s1 = "ab##c"
//    val s2 = "ad#c"
    println("After backspaces do the two Strings match? ${BackspaceStringCompare().backspaceCompare(s1, s2)}")
}