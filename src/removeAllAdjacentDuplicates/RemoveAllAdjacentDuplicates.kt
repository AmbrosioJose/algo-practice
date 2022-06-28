package removeAllAdjacentDuplicates

import java.util.*
import kotlin.collections.ArrayDeque

class CharacterTracker(val value: Char, var count: Int = 0){}
class RemoveAllAdjacentDuplicates {
    fun removeAdjacentDuplicates(s: String, k: Int) : String {
        var stack = ArrayDeque<CharacterTracker>()
        val builder = StringBuilder()

        s.forEach{ char ->
            if(stack.last().value == char){
                if(stack.last().count == 2){
                    stack.removeLast()
                } else {
                    stack.last().count++
                }
            } else {

            }
        }


        return s
    }
}