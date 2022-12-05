import java.io.*;

fun count(arr: MutableList<Int>, value: Int): Int {
    var cnt = 0
    arr.forEach { cnt += it / value }
    return cnt
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (M, N) = readLine().split(" ").map(Integer::parseInt)
    val arr = readLine().split(" ").map(Integer::parseInt).toMutableList()
    if(arr.sum() < M) {
        println(0)
    } else {
        var answer = 0
        var min = 1
        var max = 1000000000
        while(min <= max) {
            var mid = (min + max) / 2
            var cnt = count(arr, mid)
            if(cnt >= M) {
                answer = mid
                min = mid + 1
            } else {
                max = mid - 1
            }
        }
        println(answer)
    }
}