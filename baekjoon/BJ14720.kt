import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = Integer.parseInt(readLine())
    val store = readLine().split(" ").map(Integer::parseInt)
    var cur = 0
    var cnt = 0
    for(n in 0 until N) {
        if(store[n] == cur) {
            cnt++
            cur = (cur + 1) % 3
        }
    }
    println(cnt)
}