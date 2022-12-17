import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = Integer.parseInt(readLine())
    val arr = readLine().split(" ").map(Integer::parseInt)
    var max = 0
    var answer = 0
    for(n in arr.reversed()) {
        if(max < n) {
            max = n
        } else {
            answer = Math.max(answer, max - n)
        }
    }
    println(answer)
}
