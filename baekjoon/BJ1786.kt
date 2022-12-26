import java.io.*

fun search(content: String, pattern: String, preset: List<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()
    var loc = -1
    for(cur in 0 until content.length) {
        loc++
        while(loc >= 0 && content[cur] != pattern[loc]) {
            loc = if(loc > 0) preset[loc-1] + 1 else -1
        }
        if(loc == pattern.length-1) {
            result.add(cur - (pattern.length - 1))
            loc = preset[loc]
        }
    }
    return result
}

fun makePreset(pattern: String): List<Int> {
    val preset = MutableList<Int>(pattern.length, {-1})
    var prev = -1
    for(cur in 1 until pattern.length) {
        prev++
        while(prev >= 0 && pattern[cur] != pattern[prev]) {
            prev = if(prev > 0) preset[prev-1] + 1 else -1
        }
        preset[cur] = prev
    }
    return preset
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine()
    val P = readLine()
    val answer = search(T, P, makePreset(P))
    println(answer.size)
    answer.forEach { print("${it+1} ") }
}