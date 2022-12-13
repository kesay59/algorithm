import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine().split(" ").map(Integer::parseInt)
    val arr = ArrayList<Int>()
    for(n in 0 until N) {
        arr.add(Integer.parseInt(readLine()))
    }
    arr.sort()
    val memo = MutableList<Int>(K + 1) {100001}
    memo[0] = 0
    for(num in arr) {
        for(s in 0 until K) {
            var value = num + s
            while(value <= K) {
                var cnt = memo[value - num] + 1
                if(memo[value] <= cnt) {
                    break
                }
                memo[value] = cnt
                value += num
            }
        }
    }
    println(if(memo[K] != 100001) memo[K] else -1)
}