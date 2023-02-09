import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] arr1 = new int[N];
			int[] arr2 = new int[M];

			st = new StringTokenizer(br.readLine(), " ");
			for (int n = 0; n < N; n++)
				arr1[n] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++)
				arr2[m] = Integer.parseInt(st.nextToken());

			int sum = 0;
			int max_sum = 0;
			int diff = Math.abs(N - M);

			if(N <= M) {
				for (int cnt = 0; cnt < diff + 1; cnt++) {
					for (int i = cnt; i < N + cnt; i++)
						sum += arr1[i-cnt] * arr2[i];
					max_sum = Math.max(max_sum, sum);
					sum = 0;
				}
			}
			else {
				for (int cnt = 0; cnt < diff + 1; cnt++) {
					for (int i = cnt; i < M + cnt; i++)
						sum += arr2[i-cnt] * arr1[i];
					max_sum = Math.max(max_sum, sum);
					sum = 0;
				}
			}
			
			System.out.println("#" + (t+1) + " " + max_sum);
			
		}

	}

}