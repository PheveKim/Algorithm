import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

	static int r, c;
	static int[][] arr;
	static boolean[][] visited;
	static int max;
	static int cnt;
	static int area;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[r][c];
		visited = new boolean[r][c];

		for (int row = 0; row < r; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int col = 0; col < c; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		for (int row = 0; row < r; row++) {
			for (int col = 0; col < c; col++) {

				if (arr[row][col] == 1 && visited[row][col] == false) {
					area = 1;
					visited[row][col] = true;
					cnt++;
					max = Math.max(max, dfs(row, col));
				}

			}
		}

		bw.write(cnt + "\n" + max);
		bw.flush();

	}

	public static int dfs(int row, int col) {

		for (int i = 0; i < 4; i++) {

			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
				if (arr[nr][nc] != 0 && visited[nr][nc] == false) {
					area++;
					visited[nr][nc] = true;
					dfs(nr, nc);
				}
			}

		}
		return area;

	}

}