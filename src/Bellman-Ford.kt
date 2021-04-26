
/*


Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.


Example 1:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,-3}}
Output: 1
Explanation: The graph contains negative weight
cycle as 0->1->2->0 with weight -1,-2,-3,-1.
Example 2:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,3}}
Output: 0
Explanation: The graph does not contain any
negative weight cycle.


Your Task:
You don't need to read or print anything. Your task is to complete the function isNegativeWeightCycle() which takes n and edges as input paramater and returns 1 if graph contains negative weight cycle otherwise returns 0.


Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n)


Constraints:
1 <= n <= 100
1 <= m <= n*(n-1), where m is the total number of Edges in the directed graph.


* */

class Edge(val src: Int, val dest: Int, val weight: Int)
class Graph(val verticesCount: Int, val edgesCount: Int, val edges: List<Edge>)



fun isNegativeWeightCycle(graph: Graph, src: Int): Boolean {
    val dist: MutableList<Int> = MutableList(graph.edgesCount){ 0 }

    // initialize all distances to vertexes to max value except for src
    for( i in 0 until graph.verticesCount){
        if(i != src)
            dist[i] = Int.MAX_VALUE
    }

    // relax all edges v - 1 times
    for( i in 0 until graph.edgesCount){
        for(j: Int in 0 until dist.size){
            val u = graph.edges[j].src
            val v = graph.edges[j].dest
            val w = graph.edges[j].weight

            if(dist[u] != Int.MAX_VALUE && (dist[u] + w) < dist[v]) {
                dist[v] = dist[u] + w
            }
        }
    }

    // check for negative-weight cycles. The above step guarantees shortest distances if graph doesn't contain negative weight cycle. If we get a shorter path then there is a negative-weight cycle
    for(i in 0 until graph.edgesCount) {
        val u: Int = graph.edges[i].src
        val v: Int = graph.edges[i].dest
        val weight: Int = graph.edges[i].weight

        if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
            return true
    }


    return false
}

fun main(args: Array<String>){
    val edges: List<Edge> = listOf(Edge(0,1,1), Edge(1, 2, -1), Edge(2, 3, -1), Edge(3, 0, -1))
    val graph = Graph(4, 4, edges)
    print("is negative weight cycle: ${isNegativeWeightCycle(graph, 0)}")
}

