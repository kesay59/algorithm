import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (A, K) = readLine().split(" ").map(Integer::parseInt)
    val dq = ArrayDeque<Array<Int>>()
    dq.addLast(arrayOf(A, 0))
    val vis = MutableList<Boolean>(K, {false})
    while(!dq.isEmpty()) {
        var cur = dq.removeFirst()
        if(cur[0] == K) {
            println(cur[1])
            break
        }
        if(cur[0] > K || vis[cur[0]]) {
            continue
        }
        vis[cur[0]] = true
        dq.addLast(arrayOf(cur[0] * 2, cur[1] + 1))
        dq.addLast(arrayOf(cur[0] + 1, cur[1] + 1))
    }
}