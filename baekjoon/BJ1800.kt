import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, P, K) = readLine().split(' ').map(Integer::parseInt)
    val route = Array<MutableMap<Int, Int>>(N+1) {HashMap()}
    for(p in 1..P) {
        val (a, b, cost) = readLine().split(' ').map(Integer::parseInt)
        route[a] += b to cost
        route[b] += a to cost
    }
    var bot = 0
    var top = 1000000
    var answer = -1
    while(bot <= top) {
        val mid = (bot + top) / 2
        val dist = Array<Int>(N+1) {Integer.MAX_VALUE}
        dist[1] = 0
        val vis = Array<Boolean>(N+1) {false}
        var cur = 1
        do {
            vis[cur] = true
            for((next, cost) in route[cur]) {
                val d = if(cost > mid) 1 else 0
                if(dist[cur] + d < dist[next]) {
                    dist[next] = dist[cur] + d
                }
            }
            var next = 0
            for(n in 1..N) {
                if(!vis[n] && dist[n] < dist[next]) {
                    next = n
                }
            }
            cur = next;
        } while(next != 0)
        if(dist[N] > K) {
            bot = mid + 1
        } else {
            answer = mid
            top = mid - 1
        }
    }
    println(answer)
}