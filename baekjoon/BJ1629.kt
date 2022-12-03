import java.io.*;

fun evenPow(a: Long, C: Int) = a * a % C

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (A, B, C) = readLine().split(" ").map(Integer::parseInt)
    val rm: ArrayList<Long> = ArrayList<Long>()
    var a = A.toLong()
    var b = B
    while(b > 1) {
        if(b % 2 != 0) {
            b--
            rm.add(a)
        }
        a = evenPow(a, C)
        b /= 2
    }
    rm.forEach { a = a * it % C }
    println(a % C)
}