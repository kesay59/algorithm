import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BJ 3190 뱀
public class BJ3190 {

   private static class Snake{
      int r, c;
      Snake next = null;
      Snake pre = null;
      
      Snake(int r, int c) {
         this.r = r;
         this.c = c;
      }
   }
   

   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int len = Integer.parseInt(br.readLine());
      int[][] map = new int[len][len];
      int[] dr = new int[] {-1, 0, 1, 0};
      int[] dc = new int[] {0, 1, 0, -1};
      
      int an = Integer.parseInt(br.readLine());
      for(int i = 0 ; i < an; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
      }
      
      Snake head, tail;
      head = tail = new Snake(0, 0);
      int dir = 1;
      map[0][0] = 2;
      
      int answer = 0;
      int mn = Integer.parseInt(br.readLine());
      for(int m = 0; m < mn; m++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int cnt = Integer.parseInt(st.nextToken()) - answer;
         for(int c = 0; c < cnt; c++) {
            int i = head.r + dr[dir];
            int j = head.c + dc[dir];
            if(i >= len || i < 0 || j < 0 || j >= len || map[i][j] == 2) {
            	System.out.println(answer+1);
            	System.exit(0);
            } else if(map[i][j] == 1) {
            	Snake tmp = new Snake(i, j);
            	tmp.next = head;
            	head.pre = tmp;
            	head = tmp;
            	map[head.r][head.c] = 2;
            	answer++;
            } else {
            	Snake tmp = new Snake(i, j);
            	tmp.next = head;
            	head.pre = tmp;
            	head = tmp;
            	map[head.r][head.c] = 2;
            	map[tail.r][tail.c] = 0;
            	tail = tail.pre;
            	tail.next = null;
            	answer++;
            }
             
         }
         char ch = st.nextToken().charAt(0);
         if(ch == 'D') dir = (dir + 1) % 4;
         else dir = (dir - 1 + 4) % 4;
      }
      while(true) {
          int i = head.r + dr[dir];
          int j = head.c + dc[dir];
          if(i >= len || i < 0 || j < 0 || j >= len || map[i][j] == 2) {
          	System.out.println(answer+1);
          	System.exit(0);
          } else if(map[i][j] == 1) {
          	Snake tmp = new Snake(i, j);
          	tmp.next = head;
          	head.pre = tmp;
          	head = tmp;
          	map[head.r][head.c] = 2;
          	answer++;
          } else {
          	Snake tmp = new Snake(i, j);
          	tmp.next = head;
          	head.pre = tmp;
          	head = tmp;
          	map[head.r][head.c] = 2;
          	map[tail.r][tail.c] = 0;
          	tail = tail.pre;
          	tail.next = null;
          	answer++;
          }
           
       }
      
   }

}