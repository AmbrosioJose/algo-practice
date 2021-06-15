package dfs
import java.util.LinkedList

class Graph(private val vertexCount: Int) {
    private val linkedList: MutableList<LinkedList<Int>> = mutableListOf<LinkedList<Int>>()

    init{
        for(i in 0 ..vertexCount){
            linkedList.add(LinkedList<Int>())
        }
    }

    fun addEdge(v: Int, dest: Int){
        linkedList[v].add(dest)
    }

    private fun dfs(v: Int, visited: MutableList<Boolean>){
        visited[v] = true
        print("$v ")

        val iterator: MutableListIterator<Int> = linkedList[v].listIterator()
        while(iterator.hasNext()){
            val next: Int = iterator.next()
            if(!visited[next])
                dfs(next, visited)
        }
    }

    fun depthFirstSearch(v: Int){
        val visited: MutableList<Boolean> = MutableList(vertexCount){ false }
        dfs(v, visited)
    }
}

fun main(args: Array<String>){
    val g = Graph(4)
    g.addEdge(0, 1)
    g.addEdge(0, 2)
    g.addEdge(1, 2)
    g.addEdge(2, 0)
    g.addEdge(2, 3)
    g.addEdge(3, 3)

    g.depthFirstSearch(2)
}