package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 14889 스타트와 링크
public class BJ14889 {

	private static int len;
	private static int[][] arr;
	private static int min;
	private static int[] selIdx;

	private static void sel(int cnt, int idx) {
		if (cnt == len / 2) {
			int[] ar = new int[len / 2];
			int c = 0;
			out: for (int i = 0; i < len; i++) {
				for (int j = 0; j < cnt; j++) {
					if (i == selIdx[j])
						continue out;
				}
				ar[c++] = i;
			}
			int sum = 0;
			int sumD = 0;
			for (int i = 0; i < cnt - 1; i++)
				for (int j = i + 1; j < cnt; j++) {
					sum += arr[selIdx[i]][selIdx[j]] + arr[selIdx[j]][selIdx[i]];
					sumD += arr[ar[i]][ar[j]] + arr[ar[j]][ar[i]];
				}

			min = Math.min(Math.abs(sum - sumD), min);
			return;
		}
		if (idx == len)
			return;

		selIdx[cnt] = idx;
		sel(cnt + 1, idx + 1);
		sel(cnt, idx + 1);
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		arr = new int[len][len];
		selIdx = new int[len / 2];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sel(0, 0);

		System.out.println(min);

	}

}
