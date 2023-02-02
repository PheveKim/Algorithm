import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());

			int blank = N / 2;
			int center = N / 2;
			int sum = 0;
			boolean reverse = false;
			int[][] arr = new int[N][N];

			for (int k = 0; k < N; k++) {
				String each_row = br.readLine();
				for (int l = 0; l < N; l++) {
					arr[k][l] = Integer.parseInt(each_row.substring(l, l + 1));
				}
			}

			for (int row = 0; row < N; row++) {
				for (int col = blank; col < N - blank; col++) {
					sum += arr[row][col];
				}
				if (blank == 0)
					reverse = true;
				if (reverse == true)
					blank++;
				else
					blank--;
			}

			bw.write("#" + (t + 1) + " " + sum);
			bw.newLine();
			bw.flush();

		}

	}

}