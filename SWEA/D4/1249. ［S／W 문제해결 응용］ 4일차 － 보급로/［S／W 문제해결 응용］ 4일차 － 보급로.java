import javax.imageio.IIOException;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static int[][] dp;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			dp = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			dp[0][0] = 0;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
				}
			}

			bfs(0, 0);

			System.out.println("#" + (t + 1) + " " + dp[N - 1][N - 1]);

		}

	}

	public static void bfs(int r, int c) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {

			int[] popped = q.poll();
			int row = popped[0];
			int col = popped[1];

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (dp[nr][nc] > dp[row][col] + arr[nr][nc]) {
						dp[nr][nc] = dp[row][col] + arr[nr][nc];
						q.add(new int[] { nr, nc });

					}
				}

			}
		}

	}

}