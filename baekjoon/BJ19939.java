import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine().split(" ").map(Integer::parseInt)
    val stairs = (K + 1) * K / 2
    val answer = if(N >= stairs) {
        if((N - stairs) % K == 0) K - 1 else K
    } else {
        -1
    }
    println("${answer}")
}