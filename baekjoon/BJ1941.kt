import java.io.*;

fun search(map: CharArray, vis: BooleanArray, case: Int, loc: Int): Int {
    if(loc < 0 || loc >= 25 || vis[loc] || case and (1 shl loc) == 0) {
        return 0
    }
    vis[loc] = true
    var sum = 1
    sum += search(map, vis, case, loc - 5)
    sum += search(map, vis, case, loc + 5)
    if(loc % 5 != 0) {
        sum += search(map, vis, case, loc - 1)
    }
    if(loc % 5 != 4) {
        sum += search(map, vis, case, loc + 1)
    }
    return sum
}

fun checkPerson(map: CharArray, case: Int): Boolean {
    var cnt = 0
    var ds = 0
    for(i in 0 until 25) {
        if(case and (1 shl i) != 0) {
            cnt++
            if(map[i] == 'S') {
                ds++
            }
        }
    }
    return cnt == 7 && ds >= 4
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var input = ""
    for(i in 0..4) {
        input = input.plus(readLine())
    }
    val map = input.toCharArray()
    var caseCnt = 0
    for(case in 0 until (1 shl 25)) {
        if(checkPerson(map, case)) {
            var loc = 0
            for(i in 0 until 25) {
                if(case and (1 shl i) != 0) {
                    loc = i
                    break
                }
            }
            var vis = BooleanArray(25)
            if(search(map, vis, case, loc) == 7) {
                caseCnt++
            }
        }
    }
    println(caseCnt)
}