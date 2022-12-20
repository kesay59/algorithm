import java.io.*;

//val preset = listOf<Int>(
//        0, 0, 0, 0, 13, 624, 4657, 4694, 7698, 952,
//        4330, 6075, 4566, 7393, 9798, 2532, 1668, 5707, 6494, 1451,
//        5610, 360, 9054, 7264, 6421, 735, 7912, 8538, 1577, 5488,
//        3779, 3700, 8588, 6127, 7780, 5472, 789, 1634, 6898, 9133,
//        2342, 5811, 7955, 1850, 1743, 977, 4282, 7147, 536, 2086,
//        1326, 52, 1
//)

val DIVISOR = 10007
val cases = listOf<Int>(1, 4, 6, 4, 1)
val memo = Array(14) { Array(53) { Array<Int>(2) { -1 } } }
fun select(cur: Int, remain: Int, isWin: Boolean): Int {
    if(cur == 14) {
        return if(remain == 0 && isWin) 1 else 0
    }
    var answer = memo[cur][remain][if(isWin) 1 else 0]
    if(answer != -1) {
        return answer
    } else {
        answer = 0
    }
    if(remain >= 4) {
        answer = (answer + select(cur+1, remain - 4, true)) % DIVISOR
    }
    for(u in 3 downTo 0) {
        if(remain >= u) {
            answer = (answer + select(cur+1, remain - u, isWin) * cases[u]) % DIVISOR
        }
    }
    memo[cur][remain][if(isWin) 1 else 0] = answer
    return answer
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    for(k in 1..52) {
//        println(select(1, k, 1,false))
//    }
//    println(preset[Integer.parseInt(readLine())])
    println(select(1, Integer.parseInt(readLine()), false))
}