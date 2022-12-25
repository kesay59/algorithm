import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val primeNumber = MutableList<Boolean>(100001, {true})
    primeNumber[0] = false
    primeNumber[1] = false
    for(p in 2 until primeNumber.size) {
        if(primeNumber[p]) {
            for(n in p + p until primeNumber.size step p) {
                primeNumber[n] = false
            }
        }
    }
    val T = Integer.parseInt(readLine())
    testcase@ for(t in 1..T) {
        val (N, A, B) = readLine().split(" ").map(Integer::parseInt)
        for(n in A..B) {
            if(primeNumber[n]) {
                val dq = ArrayDeque<Pair<Int, Int>>()
                dq.addLast(N to 0)
                val vis = HashSet<Int>()
                while(!dq.isEmpty()) {
                    val cur = dq.removeFirst()
                    if(cur.first in A..B && primeNumber[cur.first]) {
                        println(cur.second)
                        break
                    }
                    if(vis.contains(cur.first)) {
                        continue
                    } else {
                        vis.add(cur.first)
                    }
                    if(!vis.contains(cur.first/2)) {
                        dq.addLast(cur.first/2 to cur.second+1)
                    }
                    if(!vis.contains(cur.first/3)) {
                        dq.addLast(cur.first/3 to cur.second+1)
                    }
                    if(!vis.contains(cur.first+1)) {
                        dq.addLast(cur.first+1 to cur.second+1)
                    }
                    if(cur.first>0 && !vis.contains(cur.first-1)) {
                        dq.addLast(cur.first-1 to cur.second+1)
                    }
                }
                continue@testcase
            }
        }
        println(-1)
    }
}