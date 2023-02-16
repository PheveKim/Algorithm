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

			int num = Integer.parseInt(br.readLine());
			int cnt = 1;
			int k = 0;
			int[][] arr = new int[num][num];
			boolean printed = true;
			Loop1: while (cnt <= num * num) {
				printed = false;
				for (int col = k; col < num - k; col++) {
					arr[k][col] = cnt;
					if (cnt >= num * num)
						break Loop1;
					cnt++;
					printed = true;
				}
				for (int row = k + 1; row < num - k - 1; row++) {
					arr[row][num - k - 1] = cnt;
					if (cnt >= num * num)
						break Loop1;
					cnt++;
					printed = true;
				}

				for (int col = num - k - 1; col >= k + 1; col--) {
					arr[num - k - 1][col] = cnt;
					if (cnt >= num * num)
						break Loop1;
					cnt++;
					printed = true;
				}
				for (int row = num - k - 1; row >= k + 1; row--) {
					arr[row][k] = cnt;
					if (cnt >= num * num)
						break Loop1;
					cnt++;
					printed = true;
				}

				k++;

				// num = num-2*k;
			}

			bw.write("#" + (t + 1) + "\n");
			for (int row = 0; row < num; row++) {
				for (int col = 0; col < num; col++) {
					bw.write(arr[row][col] + " ");
				}
				if(row != num-1) bw.newLine();
			}
			bw.newLine();
			bw.flush();

		}

	}

}