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

			int N = Integer.parseInt(br.readLine());
			String[][] arr = new String[N][N];

			for (int row = 0; row < N; row++) {
				String str = br.readLine();
				for (int i = 0; i < str.length(); i++) {
					arr[row][i] = str.substring(i, i + 1);
				}

			}

			String answer = "NO";
			int cnt = 0;
			int cnt2 = 0;
			Loop1: for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {

					int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
					int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

					if (arr[row][col].equals("o"))
						cnt2 = 1;
					else
						cnt2 = 0;

					for (int i = 0; i < 8; i++) {
						cnt = cnt2;
						int k = 1;
						Loop2: while (true) {
							if (row + dr[i] * k >= 0 && row + dr[i] * k < N && col + dc[i] * k >= 0
									&& col + dc[i] * k < N) {

								if (arr[row + dr[i] * k][col + dc[i] * k].equals("o")) {
									cnt++;
									if (cnt >= 5) {
										answer = "YES";
										break Loop1;
									}
									k++;

								}

								else
									break Loop2;
							}

							else
								break Loop2;
						}

						if (cnt >= 5) {
							answer = "YES";
							break Loop1;
						}

					}

				}
			}

			bw.write("#" + (t + 1) + " " + answer + "\n");
			bw.flush();
		}

	}

}