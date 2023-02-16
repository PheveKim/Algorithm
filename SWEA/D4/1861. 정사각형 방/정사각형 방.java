import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static int N;
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

			int cnt2 = 0;
			int answer = 0;
			int answer_cnt = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					max = 0;
					cnt2 = search(row, col, 1);
					if (answer_cnt < cnt2) {
						answer = arr[row][col];
						answer_cnt = cnt2;
					}

					else if (answer_cnt == cnt2) {
						if (answer > arr[row][col]) {
							answer = arr[row][col];
						}
					}
				}
			}

			bw.write("#" + (t + 1) + " " + answer + " " + answer_cnt + "\n");
			bw.flush();
		}

	}

	public static int search(int r, int c, int cnt) {

		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < N) {

				if (arr[r + dr[i]][c + dc[i]] == arr[r][c] + 1) {

					cnt++;
					search(r + dr[i], c + dc[i], cnt);

				}

			}
		}

		max = Math.max(max, cnt);
		return max;

	}

}