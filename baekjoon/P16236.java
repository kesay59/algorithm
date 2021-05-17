package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//백준 16236 아기상어
public class P16236 {
    
    private static class Shark{
        int body = 2;
        int ate = 0;
        int r, c;
        Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private static ArrayList<int[]>[] al = new ArrayList[7];
    private static LinkedList<int[]> pos = new LinkedList<int[]>();
    private static boolean[][] vis;
    private static Shark sk;
    private static int[] dr = new int[] {-1, 0, 1, 0};
    private static int[] dc = new int[] {0, 1, 0, -1};
    private static int time = 0;
    
    public static void main(String[] args) throws IOException {
        for(int i = 1; i < 7; i++) {
            al[i] = new ArrayList<>();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[][] map = new char[len][];
        for(int i = 0 ; i < len; i++) 
            map[i] = br.readLine().replace(" ", "").toCharArray();
        for(int i = 0; i < len; i++) 
            for(int j = 0; j < len; j++) {
                if(map[i][j] == 48) continue;
                else if(map[i][j] == 57) sk = new Shark(i, j);
                else {
                    al[map[i][j] - 48].add(new int[] {i, j}); 
                }
            }
        for(int[] a : al[sk.body - 1]) {
            pos.add(a);
        }
        while(true){
            vis = new boolean[len][len];
            Queue<int[]> que = new LinkedList<int[]>();
            que.add(new int[] {sk.r, sk.c, 0});
            map[sk.r][sk.c] = 48;
            vis[sk.r][sk.c] = true;
            ArrayList<int[]> sel = new ArrayList<>();
            int maxDP = Integer.MAX_VALUE;
            while(!que.isEmpty()) {
                int[] cur = que.poll();
                if(maxDP < cur[2]) break;
                for(int[] p : pos) {
                    if(cur[0] == p[0] && cur[1] == p[1]) {
                        sel.add(cur);
                        maxDP = cur[2];
                    }
                }
                for(int k = 0; k < 4; k++) {
                    try {
                        if(map[cur[0]+dr[k]][cur[1]+dc[k]] - 48 <= sk.body &&
                        		!vis[cur[0]+dr[k]][cur[1]+dc[k]]) {
                            que.offer(new int[] {cur[0]+dr[k], cur[1]+dc[k], cur[2] + 1});
                            vis[cur[0]+dr[k]][cur[1]+dc[k]] = true;
                        }
                    } catch(ArrayIndexOutOfBoundsException e) {}
                }
            }
            
            if(sel.size() == 0) {
                System.out.println(time);
                return;
            }
            else {
                int[] max = new int[] {len, len, Integer.MIN_VALUE};
                for(int[] s : sel) {
                    if(s[0] < max[0]) max = s;
                    else if(s[0] == max[0]) {
                        if(s[1] < max[1]) max = s;
                    }
                }
                int[] tmp = new int[] {-1, -1};
                for(int[] p : pos) {
                	if(p[0] == max[0] && p[1] == max[1])
                		tmp = p;
                }
        		pos.remove(tmp);
                time += max[2];
                sk.r = max[0];
                sk.c = max[1];
                sk.ate++;
                if(sk.ate == sk.body) {
                    sk.ate = 0;
                    sk.body++;
                    if(sk.body < 8)
                        for(int[] a : al[sk.body - 1])
                            pos.add(a);
                }
            }
        }
    }
}