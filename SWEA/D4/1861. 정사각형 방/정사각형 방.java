import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N;
	static int[][] arr;
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			int max_real = 0;
			int min_num = Integer.MAX_VALUE;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					max = 0;
					dfs(row, col, 1);

					int num = arr[row][col];
					if (max_real < max) {
						min_num = num;
					}
					if (max_real == max)
						if (min_num > num)
							min_num = num;

					max_real = Math.max(max, max_real);

				}
			}

			System.out.println("#" + (t + 1) + " " + min_num + " " + max_real);
		}

	}

	public static void dfs(int row, int col, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (arr[nr][nc] == arr[row][col] + 1) {
					cnt++;
					max = Math.max(max, cnt);
					dfs(nr, nc, cnt);
				}
			}
		}
	}

}