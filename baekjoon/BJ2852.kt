import java.io.*;

fun convertMinToTime(min: Int): String {
    val h = min / 60
    val m = min % 60
    return "${if(h < 10) "0${h}" else h}:${if(m < 10) "0${m}" else m}"
}

fun convertTimeToMin(time: String): Int {
    val (h, m) = time.split(":").map(Integer::parseInt)
    return h * 60 + m
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = Integer.parseInt(readLine());
    val dq = ArrayDeque<Pair<Int, Int>>()
    for(n in 1..N) {
        val (team, time) = readLine().split(" ")
        dq.addLast(Integer.parseInt(team) to convertTimeToMin(time))
    }
    dq.addLast(3 to convertTimeToMin("48:00"))
    var scoreA = 0
    var scoreB = 0
    var minA = 0
    var minB = 0
    while(true) {
        val cur = dq.removeFirst()
        when(cur.first) {
            1 -> scoreA++
            2 -> scoreB++
            3 -> break
        }
        val nextMin = dq.get(0).second
        if(scoreA > scoreB) {
            minA += nextMin - cur.second
        } else if(scoreA < scoreB) {
            minB += nextMin - cur.second
        }
    }
    println(convertMinToTime(minA))
    println(convertMinToTime(minB))
}