import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Map<Integer, List<int[]>> pointColorMap = new HashMap<Integer, List<int[]>>();
        for(int k = 1; k <= K; k++) pointColorMap.put(k, new ArrayList<int[]>());
        
        int x, y, key;
        for(int n = 1; n <= N; n++) {
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	pointColorMap.get(Integer.parseInt(st.nextToken())).add(new int[] {x, y});
        }
        
        System.out.println(new Solution().solution(N, K, pointColorMap));
    }
}

class Solution {
	
	int minWidth = Integer.MAX_VALUE;
	int pointCnt;
	int colorCnt;
	
	//square = [maxX, minX, maxY, minY]
	private void selectPointInColor(Map<Integer, List<int[]>> pointColorMap, int k, int[] square) {
		int width = (square[0] - square[1]) * (square[2] - square[3]); 
		if(width >= minWidth) return;
		if(k == colorCnt + 1) {
			minWidth = width;
			return;
		};
		if(pointColorMap.get(k).size() == 0) selectPointInColor(pointColorMap, k + 1, square);
		int[] nextSqare;
		for(int[] point : pointColorMap.get(k)) {
			nextSqare = new int[] {
					Math.max(square[0], point[0]),
					Math.min(square[1], point[0]),
					Math.max(square[2], point[1]),
					Math.min(square[3], point[1])
				};
			selectPointInColor(pointColorMap, k + 1, nextSqare);
		}
	}
	
	public int solution(int N, int K, Map<Integer, List<int[]>> pointColorMap) {
		pointCnt = N;
		colorCnt = K;
		selectPointInColor(pointColorMap, 1, new int[] {-1000, 1000, -1000, 1000});
		return minWidth;
	}
	
}