import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static int max;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];

			int max_num = 0;
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < N; col++) {
					int num = Integer.parseInt(st.nextToken());
					max_num = Math.max(max_num, num);
					arr[row][col] = num;
				}
			}

			max = 0; // 경로가 없을때가 최소이므로 max = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (arr[row][col] == max_num) {
						boolean[][] visited = new boolean[N][N];
						dfs(row, col, 0, K, visited, 0);
					}
				}
			}

			System.out.println("#" + (t + 1) + " " + max);
		}

	}

	public static void dfs(int row, int col, int cnt, int K, boolean[][] visited, int gap) {

		cnt++;
		if (gap > 0)
			K = Integer.MIN_VALUE;
		visited[row][col] = true;
		int current_value = arr[row][col] - gap;


		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (arr[nr][nc] < current_value && visited[nr][nc] == false) {
					gap = 0;
					dfs(nr, nc, cnt, K, visited, gap);
					visited[nr][nc] = false;

				} else if (arr[nr][nc] - current_value < K && K > 0 && visited[nr][nc] == false) {
					gap = arr[nr][nc] - arr[row][col] + 1;
					dfs(nr, nc, cnt, K, visited, gap);
					visited[nr][nc] = false;

				} else {
					max = Math.max(max, cnt);
				}
			}

		}

	}

}