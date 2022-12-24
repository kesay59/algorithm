import java.io.*
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = Integer.parseInt(readLine())
    val M = Integer.parseInt(readLine())
    val arr = Array<HashMap<Int, Int>>(N+1, {HashMap<Int, Int>()})
    for(n in 1..N) {
        arr[n].put(n, 0)
    }
    for(m in 1..M) {
        val (a, b, c) = readLine().split(" ").map(Integer::parseInt)
        val prev = arr[a].get(b)
        if(prev == null || prev > c) {
            arr[a].put(b, c)
            arr[b].put(a, c)
        }
    }
    var sum = 0
    val vis = MutableList<Boolean>(N+1) {false}
    val pq = PriorityQueue<Triple<Int, Int, Int>>() {t1, t2 -> t1.third - t2.third}
    arr.get(1).forEach{ (key, value) -> pq.offer(Triple(1, key, value)) }
    vis[1] = true
    while(!pq.isEmpty()) {
        val cur = pq.poll()
        if(vis[cur.second]) {
            continue
        }
        vis[cur.second] = true
        arr.get(cur.second).forEach{ (key, value) -> pq.offer(Triple(cur.second, key, value)) }
        sum += cur.third
    }
    println(sum)
}