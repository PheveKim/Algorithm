import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int[] arr;
	static int N;
	static int max_length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			max_length = 0;
			int[] dp = new int[N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<i; j++) {
					if(arr[j] <= arr[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				max_length = Math.max(max_length, dp[i]);
			}
			
			bw.write("#" + (t+1) + " " + (max_length+1));
			bw.newLine();
			bw.flush();
		}
	}
}

	
//	public static void choose(int last_idx, int last_num, int length) {
//		System.out.println(last_idx + " " + last_num + " " + length);
//		for(int i=last_idx+1; i<N; i++) {
//			if(arr[i] >= last_num) {
//				max_length = Math.max(max_length, length+1);
//				choose(i, arr[i], length+1);
//			}
//		}
//	}
//}