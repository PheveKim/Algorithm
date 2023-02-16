import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];

			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			int max2 = 0;
			int max_final = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					int sum = arr[row][col];
					int sum2 = arr[row][col];
					int k = 1;

					while (true) {
						if (k >= M)
							break;
						int dr[] = { -k, k, 0, 0 };
						int dc[] = { 0, 0, -k, k };

						int dr2[] = { -k, -k, k, k };
						int dc2[] = { -k, k, -k, k };
						for (int i = 0; i < 4; i++) {
							if (row + dr[i] >= 0 && row + dr[i] < N && col + dc[i] >= 0 && col + dc[i] < N) {
								sum += arr[row + dr[i]][col + dc[i]];
							}
							if (row + dr2[i] >= 0 && row + dr2[i] < N && col + dc2[i] >= 0 && col + dc2[i] < N) {
								sum2 += arr[row + dr2[i]][col + dc2[i]];
							}
						}

						k++;

					}

					// System.out.println(sum + " " + sum2);
					max = Math.max(max, sum);
					max2 = Math.max(max2, sum2);
					max_final = Math.max(max, max2);

				}
			}

			bw.write("#" + (t + 1) + " " + max_final + "\n");
			bw.flush();
		}

	}

}