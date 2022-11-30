import java.io.*;
import kotlin.math.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map(Integer::parseInt)
    val arrayList = arrayListOf<Int>()
    for(i in (1..M)) {
        arrayList.add(Integer.parseInt(readLine()))
    }
    var bot = 1
    var top = (10.0).pow(9).toInt()
    var answer = 0
    while(bot <= top) {
        var mid = (top + bot) / 2
        var cnt = 0
        for(num in arrayList) {
            cnt += num / mid + if(num % mid != 0) 1 else 0
        }
        if(cnt <= N) {
            answer = mid
            top = mid - 1
        } else {
            bot = mid + 1
        }
    }
    println(answer)
}