import java.io.*;

fun search(airport: MutableList<Int>, loc: Int): Int {
    if(loc == 0) {
        return 0
    }
    if(airport[loc] == loc) {
        return loc
    } else {
        airport[loc] = search(airport, airport[loc])
        return airport[loc]
    }
}

fun select(airport: MutableList<Int>, loc: Int): Int {
    if(airport[loc] == 0) {
        return -1
    }
    if(airport[loc] == loc) {
        airport[loc] = search(airport, loc - 1)
        return airport[loc]
    } else {
        airport[loc] = select(airport, airport[loc])
        return airport[loc]
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val G = Integer.parseInt(readLine())
    val P = Integer.parseInt(readLine())
    val airport = MutableList<Int>(G+1) { it }
    var cnt = 0
    for(idx in 1..P) {
        if(select(airport, Integer.parseInt(readLine())) == -1) {
            break
        } else {
            cnt++
        }
    }
    println(cnt)
}