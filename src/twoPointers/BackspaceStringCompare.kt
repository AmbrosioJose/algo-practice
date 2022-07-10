package twoPointers

class BackspaceStringCompare {
    /*
    Time: O(n) Since we go through both Strings once. So O(t + s) => O(n) n being which ever is bigger
    Space: O(1) Since we only use 4 variables. 2 counters and 2 pointers
    */
    fun backspaceCompare(s: String, t: String): Boolean {
        var sI = s.length - 1
        var tI = t.length - 1

        var skipS = 0
        var skipT = 0
        while(sI >= 0 || tI >= 0){
            // skip backspace and backspaced characters until we find a non backspaced character or reach the end
            while(sI >= 0 && (skipS != 0 || s[sI] == '#')){
                if(s[sI] == '#'){ skipS++; sI--}
                else if(skipS > 0){ sI--; skipS--}
            }

            // skip backspace and backspaced characters until we find a non backspaced character or reach the end
            while(tI >= 0 && (skipT != 0 || t[tI] == '#')){
                if(t[tI] == '#'){ skipT++; tI--}
                else if(skipT > 0) {skipT--; tI--}
            }

            // if only 1 has reached the end
            if((sI >= 0) != (tI >= 0)) return false

            // if two characters are diffrent
            if(sI >= 0 && tI >= 0 && s[sI] != t[tI]) return false


            sI--; tI--
        }
        return true
    }
}

fun main(){
//    val s1 = "ab#c"
//    val s2 = "ad#c"

//    val s1 = "bb#c"
//    val s2 = "ad#c"

    val s1 = "ab##c"
    val s2 = "ad#c"
    println("After backspaces do the two Strings match? ${BackspaceStringCompare().backspaceCompare(s1, s2)}")
}