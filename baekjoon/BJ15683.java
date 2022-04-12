import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15683 {
	private static int minArea = Integer.MAX_VALUE;
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	private static void checkDir(boolean[][] vis, char[][] map, int posR, int posC, int dir) {
		while(posR >= 0 && posR < vis.length && posC >= 0 && posC < vis[0].length) {
			if(map[posR][posC] == '6') break;
			vis[posR][posC] = true;
			posR += dr[dir];
			posC += dc[dir];
		}
	}
	private static void runCamera(int depth, ArrayList<int[]> camera, int[] camDir, char[][] map) {
		if(depth == camera.size()) {
			boolean[][] vis = new boolean[map.length][map[0].length];
			for(int i = 0; i < camera.size(); i++) {
				if(camera.get(i)[2] == 1) {
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], camDir[i]);
				} else if(camera.get(i)[2] == 2) {
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], camDir[i]);
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], camDir[i]+2);
				} else if(camera.get(i)[2] == 3) {
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], camDir[i]);
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], (camDir[i]+1)%4);
				} else if(camera.get(i)[2] == 4) {
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], camDir[i]);
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], (camDir[i]+1)%4);
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], (camDir[i]+2)%4);
				} else if(camera.get(i)[2] == 5) {
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], 0);
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], 1);
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], 2);
					checkDir(vis, map, camera.get(i)[0], camera.get(i)[1], 3);
				}
			}
			int cnt = 0;
			for(int i = 0; i < vis.length; i++) {
				for(int j = 0; j < vis[0].length; j++) {
					if(!vis[i][j] && map[i][j] != '6') cnt++;
				}
			}
			minArea = Math.min(cnt, minArea);
			return;
		}
		if(camera.get(depth)[2] == 1) {
			camDir[depth] = 0;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 1;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 2;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 3;
			runCamera(depth+1, camera, camDir, map);
		} else if(camera.get(depth)[2] == 2) {
			camDir[depth] = 0;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 1;
			runCamera(depth+1, camera, camDir, map);
		} else if(camera.get(depth)[2] == 3) {
			camDir[depth] = 0;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 1;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 2;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 3;
			runCamera(depth+1, camera, camDir, map);
		} else if(camera.get(depth)[2] == 4) {
			camDir[depth] = 0;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 1;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 2;
			runCamera(depth+1, camera, camDir, map);
			camDir[depth] = 3;
			runCamera(depth+1, camera, camDir, map);
		} else if(camera.get(depth)[2] == 5) {
			runCamera(depth+1, camera, camDir, map);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for(int i = 0; i < row; i++) {
			map[i] = br.readLine().replaceAll(" ", "").toCharArray();
		}
		ArrayList<int[]> camera = new ArrayList<>();
		for(int r = 0; r< row; r++) {
			for(int c = 0; c < col; c++) {
				if(map[r][c] > '0' && map[r][c] < '6') camera.add(new int[] {r, c, map[r][c] - 48});
			}
		}
		runCamera(0, camera, new int[camera.size()], map);
		System.out.println(minArea);
	}
}
