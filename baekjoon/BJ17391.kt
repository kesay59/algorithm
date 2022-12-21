import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (R, C) = readLine().split(" ").map(Integer::parseInt)
    val map = MutableList<List<Int>>(R, { listOf() });
    for(r in 0 until R) {
        map[r] = readLine().split(" ").map(Integer::parseInt)
    }
    val vis = MutableList<MutableList<Boolean>>(R, {MutableList<Boolean>(C, {false})})
    val dq = ArrayDeque<Array<Int>>()
    dq.addLast(arrayOf(0, 0, 0))
    while(!dq.isEmpty()) {
        val cur = dq.removeFirst()
        if(cur[0] == R-1 && cur[1] == C-1) {
            println(cur[2])
            break
        }
        if(vis[cur[0]][cur[1]]) {
            continue
        }
        vis[cur[0]][cur[1]] = true
        for(n in 1..map[cur[0]][cur[1]]) {
            if(cur[0] + n >= R) {
                break
            }
            if(vis[cur[0] + n][cur[1]]) {
                continue
            }
            dq.addLast(arrayOf(cur[0] + n, cur[1], cur[2] + 1))
        }
        for(n in 1..map[cur[0]][cur[1]]) {
            if(cur[1] + n >= C) {
                break
            }
            if(vis[cur[0]][cur[1] + n]) {
                continue
            }
            dq.addLast(arrayOf(cur[0], cur[1] + n, cur[2] + 1))
        }
    }
}