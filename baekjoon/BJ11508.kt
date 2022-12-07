import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = Integer.parseInt(readLine())
    val list = MutableList<Int>(N) {0};
    for(i in 0 until N) {
        list[i] = Integer.parseInt(readLine())
    }
    list.sortDescending()
    var sum = 0
    list.forEachIndexed { index, ele -> if(index % 3 != 2) sum += ele }
    println(sum)
}