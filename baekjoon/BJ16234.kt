import java.io.*;

val dr = arrayOf(-1, 0, 1, 0)
val dc = arrayOf(0, -1, 0, 1)

fun move(map: Array<Array<Int>>, arrayList: ArrayList<Pair<Int, Int>>) {
    var value = 0
    for(loc in arrayList) {
        value += map[loc.first][loc.second]
    }
    value /= arrayList.size
    for(loc in arrayList) {
        map[loc.first][loc.second] = value
    }
}

fun find(map: Array<Array<Int>>, vis: Array<Array<Boolean>>, L: Int, R: Int, loc: Pair<Int, Int>): Boolean {
    val arrayList = ArrayList<Pair<Int, Int>>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(loc)
    while(!queue.isEmpty()) {
        val cur = queue.removeFirst()
        if(vis[cur.first][cur.second]) {
            continue
        }
        vis[cur.first][cur.second] = true
        arrayList.add(cur)
        for(d in 0..3) {
            val nr = cur.first + dr[d]
            val nc = cur.second + dc[d]
            if(nr in 0..map.size-1 && nc in 0..map.size-1 && !vis[nr][nc] && Math.abs(map[cur.first][cur.second] - map[nr][nc]) in L..R) {
                queue.addLast(Pair(nr, nc))
            }
        }
    }
    move(map, arrayList)
    return arrayList.size > 1
}

fun connect(map: Array<Array<Int>>, L: Int, R: Int): Boolean {
    var flag = false
    val vis: Array<Array<Boolean>> = Array(map.size) { Array<Boolean>(map.size) { false } }
    map.forEachIndexed { r, col ->
        col.forEachIndexed { c, value ->
            if(!vis[r][c]) {
                if(find(map, vis, L, R, Pair(r, c))) {
                    flag = true
                }
            }
        }
    }
    return flag
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, L, R) = readLine().split(" ").map(Integer::parseInt)
    val map: Array<Array<Int>> = Array<Array<Int>>(N) { readLine().split(" ").map(Integer::parseInt).toTypedArray() }
    var cnt = 0
    while(connect(map, L, R)) cnt++
    print(cnt)
}