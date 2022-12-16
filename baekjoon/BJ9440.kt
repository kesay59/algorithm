import java.io.*;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while(true) {
        val input = readLine().split(" ").map(Integer::parseInt)
        if(input[0] == 0) break
        val arr = input.subList(1, input.size).sorted().toMutableList()
        if(arr[0] == 0) {
            for(i in 1 until arr.size) {
                if(arr[i] != 0) {
                    arr[0] = arr[i]
                    arr[i] = 0
                    break
                }
            }
        }
        if(arr[1] == 0) {
            for(i in 2 until arr.size) {
                if(arr[i] != 0) {
                    arr[1] = arr[i]
                    arr[i] = 0
                    break
                }
            }
        }
        val ans = Array<ArrayList<Char>>(2) { ArrayList<Char>() }
        var flag = 0
        for(num in arr) {
            ans[flag].add(num.digitToChar())
            flag = flag xor 1
        }
        val a = Integer.parseInt(String(ans[0].toCharArray()))
        val b = Integer.parseInt(String(ans[1].toCharArray()))
        println(a+b)
    }
}