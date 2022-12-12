import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine().split(" ").map(Integer::parseInt)
    val dp = Array<Array<Int>>(K+1) { if(it == 1) Array<Int>(N+1) { 1 } else Array<Int>(N+1) { 0 } }
    for(k in 1 until K) {
        for(n in 0..N) {
            for(m in 0..N) {
                if(n+m <= N) {
                    dp[k+1][n+m] = (dp[k+1][n+m] + dp[k][n]) % 1_000_000_000
                }
            }
        }
    }
    println(dp[K][N])
}