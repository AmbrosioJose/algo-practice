package gridTraveler

fun gridTraveler(x: Int, y: Int): Long{
    val table: MutableList<MutableList<Long>> = MutableList(y + 1){MutableList( x + 1) { 0L} }
    for(i : Int in  0 ..y){
        table.add(MutableList(x + 1) {0L})
    }

    table[1][1] = 1

    for(i in 1..y){
        for(j in 1..x){
            table[i][j] += table[i - 1][j]
            table[i][j] += table[i][j - 1]
        }
    }

    return table[y][x]
}

fun main(args: Array<String>){
    println(gridTraveler(1 , 1))
    println(gridTraveler(2 , 3))
    println(gridTraveler(3 , 2))
    println(gridTraveler(3 , 3))
    println(gridTraveler(18 , 18))
}