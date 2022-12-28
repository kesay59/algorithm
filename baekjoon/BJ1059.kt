import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    val store = readLine().split(" ").map(Integer::parseInt).sorted()
    val N = Integer.parseInt(readLine())
    for(k in store.withIndex()) {
        if(k.value >= N) {
            val a = if(k.index == 0) 0 else store[k.index-1]
            val b = k.value
            println(if(N==b) 0 else (b-a-2) + (N-a-1)*(b-N-1))
            break
        }
    }
}