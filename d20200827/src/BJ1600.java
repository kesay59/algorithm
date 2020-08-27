import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1600. 말이 되고픈 원숭이
public class BJ1600 {

   private static class Move {
      int r, c, dp, tm;

      Move(int r, int c, int dp, int tm) {
         this.r = r;
         this.c = c;
         this.dp = dp;
         this.tm = tm;
      }
   }

   private static int[] dhr = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
   private static int[] dhc = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
   private static int[] dmr = new int[] { -1, 0, 1, 0 };
   private static int[] dmc = new int[] { 0, 1, 0, -1 };

   public static void main(String[] args) throws IOException {
	  //입력 받기
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int lim = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int col = Integer.parseInt(st.nextToken());
      int row = Integer.parseInt(st.nextToken());
      char[][] map = new char[row][col];
      for (int i = 0; i < row; i++)
         map[i] = br.readLine().replace(" ", "").toCharArray();

      //visit 배열 [행][열][말처럼 움직인 횟수]
      boolean[][][] vis = new boolean[row][col][lim + 1];
      Queue<Move> que = new LinkedList<Move>();
      que.add(new Move(0, 0, 0, 0));
      for(int t = 0; t < lim + 1; t++)
         vis[0][0][t] = true;
      
      //queue 실행
      while (!que.isEmpty()) {
         Move cur = que.poll();
         if (cur.r == row - 1 && cur.c == col - 1) {
            System.out.println(cur.dp);
            return;
         }
         
         //말처럼 움직이는데 lim을 넘어서면 더이상 불가능
         if (cur.tm < lim)
            for (int k = 0; k < 8; k++) {
               try {
                  int r = cur.r + dhr[k];
                  int c = cur.c + dhc[k];
                  if (map[r][c] != 49 && !vis[r][c][cur.tm + 1]) {
                     que.add(new Move(r, c, cur.dp + 1, cur.tm + 1));
                     for(int t = cur.tm+1; t < lim + 1; t++)
                        vis[r][c][t] = true;
                  }
               } catch (IndexOutOfBoundsException e) {}
            }
         //원숭이처럼 움직이기
         for (int k = 0; k < 4; k++) {
            try {
               int r = cur.r + dmr[k];
               int c = cur.c + dmc[k];
               if (map[r][c] != 49 && !vis[r][c][cur.tm]) {
                  que.add(new Move(r, c, cur.dp + 1, cur.tm));
                  for(int t = cur.tm; t < lim + 1; t++)
                     vis[r][c][t] = true;
               }
            } catch (IndexOutOfBoundsException e) {
            }
         }
      }
      System.out.println(-1);
   }
}