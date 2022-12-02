import java.io.*;

fun check(arr: List<Int>, value: Int, M: Int): Boolean {
    var cnt = 0
    var copy = 0
    arr.forEach {
        if(it <= copy) {
            copy -= it
        } else {
            cnt++
            copy = value - it
        }
    }
    return cnt <= M
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map(Integer::parseInt)
    val arr: List<Int> = readLine().split(" ").map(Integer::parseInt).toMutableList()
    var min = 0
    arr.forEach { min = Math.max(it, min) }
    var max = 1000000000
    var answer = 0
    while(min <= max) {
        var mid = (max + min) / 2
        if(check(arr, mid, M)) {
            answer = mid
            max = mid - 1
        } else {
            min = mid + 1
        }
    }
    println(answer)
}