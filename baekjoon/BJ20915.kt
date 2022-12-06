import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val testCase = Integer.parseInt(readLine())
    for(tc in 1..testCase) {
        val arr = readLine().toCharArray().map { if(it == '6') '9' else it }.sortedDescending()
        val list = MutableList<ArrayList<Char>>(2) { arrayListOf('0') }
        var flag = 0
        arr.forEach {
            list[flag].add(it)
            flag = if(list[0].joinToString(separator = "").toLong() > list[1].joinToString(separator = "").toLong()) 1 else 0
        }
        println(list[0].joinToString(separator = "").toLong() * list[1].joinToString(separator = "").toLong())
    }
}