import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (A, B, C, M) = readLine().split(" ").map(Integer::parseInt)
    var value = 0
    var work = 0
    for(t in 0 until 24) {
        if(value + A <= M) {
            value += A
            work += B
        } else {
            value = Math.max(0, value - C)
        }
    }
    println(work)
}