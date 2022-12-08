import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stc1 = "+".plus(readLine()).toCharArray()
    val stc2 = "-".plus(readLine()).toCharArray()
    val table = Array<Array<Int>>(stc2.size) { Array<Int>(stc1.size) { 0 } }
    for(i in 1 until stc2.size) {
        for(j in 1 until stc1.size) {
            table[i][j] = Math.max(table[i-1][j], table[i][j-1])
            if(stc2[i] == stc1[j]) {
                table[i][j] = Math.max(table[i][j], table[i-1][j-1] + 1)
            }
        }
    }
    val list = ArrayList<Char>()
    var i = stc2.size - 1
    var j = stc1.size - 1
    while(table[i][j] != 0) {
        when(table[i][j]) {
            table[i][j-1] -> {
                j--
            }
            table[i-1][j] -> {
                i--
            }
            else -> {
                list.add(stc1[j])
                i--
                j--
            }
        }
    }
    list.reverse()
    val answer = String(list.toCharArray())
    println(if(answer.isEmpty()) "0" else "${answer.length}\n$answer")
}