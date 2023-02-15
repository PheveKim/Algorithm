import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			int answer = 0;
			Loop1: for (int col = 0; col < 100; col++) {

				if (arr[0][col] == 1) {

					int col_cnt = col;
					int row_cnt = 0;
					String before = "";
					
					Loop2: while (true) {

						boolean no_side = true;
						
						//System.out.println(col_cnt);
						if (col_cnt != 0 && arr[row_cnt][col_cnt - 1] == 1 && !before.equals("left")) {
							col_cnt = col_cnt - 1;
							no_side = false;
							before = "right";
						}
						else if (col_cnt != 99 && arr[row_cnt][col_cnt + 1] == 1 && !before.equals("right")) {
							col_cnt = col_cnt + 1;
							no_side = false;
							before = "left";
							//System.out.println(col_cnt);
						}

						if (no_side) {
							row_cnt = row_cnt + 1;
							before = "";
						}
						// System.out.println(row_cnt +" "+ col_cnt + " " + arr[row_cnt][col_cnt]);
						if (row_cnt >= 99) {
							//System.out.println("end  " +  arr[row_cnt][col_cnt]);
							if (arr[row_cnt][col_cnt] == 2) {
								answer = col;
								break Loop1;
							}
							break Loop2;
						}

					}

				}

			}

			bw.write("#" + (t + 1) + " " + answer + "\n");
			bw.flush();

		}

	}
}