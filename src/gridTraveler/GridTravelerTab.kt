package gridTraveler

fun gridTraveler(x: Int, y: Int): Int{
    val table: MutableList<MutableList<Int>> = mutableListOf()
    for(i : Int in  0 ..y){
        table.add(MutableList(x + 1) {0})

    }

    table[1][1] = 1

    for(i in 1..y){
        for(j in 1..x){
            table[i][j] += table[i - 1][j]
            table[i][j] += table[i][j - 1]
        }
    }

//    for(i in 0..y){
//        for(j in 0..x){
//            val current = table[i][j]
//
//            if((j + 1) < x) table[i][j + 1] += current
//            if((i + 1) < y) table[i + 1][j] += current
//            if((j + 1) < x && (i + 1) < y)
//                println("current $current, i: $i, j: $j newJ:${table[i][j + 1]}, newi: ${table[i + 1][j]}")
//            else if((j + 1) < x)
//                println("current $current, i: $i, j: $j newJ:${table[i][j + 1]}")
//            else if((i + 1) < x)
//                println("current $current, i: $i, j: $j newi: ${table[i + 1][j]}")
//
//        }
//    }

    print(table)
    return table[y][x]
}

fun main(args: Array<String>){
//    println(gridTraveler(1 , 1))
    println(gridTraveler(2 , 3))
//    println(gridTraveler(3 , 2))
//    println(gridTraveler(3 , 3))
//    println(gridTraveler(18 , 18))
}