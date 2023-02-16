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

			String answer = "yes";
			String[][] arr = new String[8][8];

			for (int row = 0; row < 8; row++) {
				String str = br.readLine();
				for (int col = 0; col < 8; col++) {
					arr[row][col] = str.substring(col, col + 1);
				}
			}

			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			int lcnt = 0;

			Loop1: for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++) {
					if (arr[row][col].equals("O")) {
						lcnt++;
						for (int i = 0; i < 4; i++) {
							int k = 1;
							while (true) {
								if (row + dr[i] * k >= 0 && row + dr[i] * k < 8 && col + dc[i] * k >= 0
										&& col + dc[i] * k < 8) {
									if (arr[row + dr[i] * k][col + dc[i] * k].equals("O")) {
										answer = "no";
										break Loop1;
									}

									k++;

								}

								else
									break;

							}

						}

					}

				}
			}

			if (lcnt != 8)
				answer = "no";
			bw.write("#" + (t + 1) + " " + answer + "\n");
			bw.flush();
		}

	}

}