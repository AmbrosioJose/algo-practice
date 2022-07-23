package dynamic

class DecodeWays {
    fun numDecodings(s: String): Int {
        if(s.isEmpty() || s[0] == '0') return 0

        var decodeCount = 1
        for(i in 0 until s.length - 1){
            if(isValidPair(s, i, i + 1) ){
                if(s[i + 1] != '0')
                    decodeCount++
            } else if( s[i + 1] == '0')
                return 0
        }
        return decodeCount
    }

    // 2101
    fun cachedNumDecodings(s: String): Int{
        val dp = hashMapOf(s.length to 1)
        return dfs(s, dp, 0)
    }

    fun dfs(s: String, cache: HashMap<Int, Int>, i: Int): Int{
        if(cache.containsKey(i)) return cache[i]!!
        if(s[i]=='0') return 0

        var res = dfs(s, cache, i + 1)

        if(isValidPair(s, i, i + 1))
            res += dfs(s, cache, i + 2)

        cache[i] = res
        return res
    }

    fun isValidPair(s: String, left: Int, right: Int):Boolean{
        return right < s.length && s[left] > '0' && (10 * (s[left] - '0') + (s[right] - '0')) <= 26
    }
}

fun main(){
    val s = "06"

    println(DecodeWays().cachedNumDecodings(s))
}