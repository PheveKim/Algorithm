import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[] arr;
	static int N;
	static int max_length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		int[] dp = new int[N];
		String[] history = new String[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		max_length = 0;
		for(int i=0; i<N; i++) {
			history[i] = Integer.toString(arr[i]);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					if(dp[j]+1 > dp[i]) {
						dp[i] = dp[j]+1;
						history[i] = history[j] + " " + Integer.toString(arr[i]);
					}
				}
			}
			max_length = Math.max(max_length, dp[i]);
		}
		
		bw.write(max_length + " ");
		bw.newLine();
//		System.out.println(Arrays.toString(history));
		for(int i=0; i<history.length; i++) {
			if(history[i] == null) continue;
			st = new StringTokenizer(history[i], " ");
			int st_len = st.countTokens();
			if(st_len == max_length) {
				for(int j=0; j<st_len; j++) {
					bw.write(Integer.parseInt(st.nextToken()) + " ");
				}
				break;
			}
		}
		bw.flush();
	}
}