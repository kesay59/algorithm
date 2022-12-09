import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var line = readlnOrNull()
    while(line != null) {
        val (target, stc) = line.split(" ")
        var cur = 0
        for(ch in stc) {
            if(target[cur] == ch) {
                cur++
                if(cur == target.length) break
            }
        }
        println(if(cur == target.length) "Yes" else "No")
        line = readlnOrNull()
    }
}