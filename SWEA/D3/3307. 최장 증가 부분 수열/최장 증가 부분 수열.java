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
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			int[] dp = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = 1;
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[j] <= arr[i])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(max, dp[i]);
			}

			bw.write("#" + (t + 1) + " " + max);
			bw.newLine();
			bw.flush();

		}

	}

}