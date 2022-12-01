import java.io.*;

fun dfs(vertices: Array<ArrayList<Int>>, dp: Array<Array<Int>>, Y: Int, cnt: Int, loc: Int, answer: HashSet<Int>): Int {
    if(cnt == Y) {
        answer.add(loc)
        dp[loc][cnt] = 1
        return dp[loc][cnt]
    }
    var sum = 0
    for(vertex in vertices[loc]) {
        if(dp[vertex][cnt+1] == 0) {
            dfs(vertices, dp, Y, cnt+1, vertex, answer)
        }
        sum += dp[vertex][cnt+1]
    }
    dp[loc][cnt] = sum
    return sum
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, X, Y) = readLine().split(" ").map(Integer::parseInt)
    val vertices = Array<ArrayList<Int>>(N+1) { ArrayList<Int>() }
    for(i in (1..M)) {
        val (a, b) = readLine().split(" ").map(Integer::parseInt)
        vertices[a].add(b)
        vertices[b].add(a)
    }
    val dp = Array<Array<Int>>(N+1) { Array(Y+1) { 0 } }
    val answers = HashSet<Int>()
    dfs(vertices, dp, Y, 0, X, answers)
    if(answers.isEmpty()) {
        println(-1)
    } else {
        println(answers.sorted().joinToString(separator = " "))
    }
}