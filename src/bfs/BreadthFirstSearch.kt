package bfs

import java.util.LinkedList

class Graph(private val vertexCount: Int){
    private val linkedListL = mutableListOf<LinkedList<Int>>()

    init{
        for(i in 0..vertexCount){
            linkedListL.add(LinkedList())
        }
    }

    fun addEdge(v: Int, destination: Int){
        linkedListL[v].add(destination)
    }

    fun bfs(v: Int){
        val visited: MutableList<Boolean> = MutableList<Boolean>(vertexCount){ false }

        val queue: LinkedList<Int> = LinkedList<Int>()

        visited[v] = true
        queue.add(v)

        while(queue.size != 0){
            val dequeuedVertex: Int = queue.poll()
            print("$dequeuedVertex ")

            val iterator: MutableListIterator<Int> = linkedListL[dequeuedVertex].listIterator()
            while(iterator.hasNext()){
                val next: Int = iterator.next()
                if(!visited[next]){
                    queue.add(next)
                    visited[next] = true
                }
            }
        }

    }
}

fun main(args: Array<String>){
    val graph: Graph = Graph(4)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 2)
    graph.addEdge(2, 0)
    graph.addEdge(2, 3)
    graph.addEdge(3, 3)

    graph.bfs(2)
}