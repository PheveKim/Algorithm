import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static boolean[] visited;
	static int[][] arr;
	static int n;
	static int m;
	static int cnt;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int days = Integer.parseInt(st.nextToken());
			int earn = Integer.parseInt(st.nextToken());
			
			arr[i][0] = days;
			arr[i][1] = earn;
		}
		
		max = Integer.MIN_VALUE;
		dfs(1, 0);
		System.out.println(max);
	}
	
	
	public static void dfs(int today, int earn_sum) {
		max = Math.max(max,  earn_sum);
		for(int i=today; i<n+1; i++) {
			if(i + arr[i][0] <= n+1) {
				dfs(i + arr[i][0], earn_sum + arr[i][1]);
			}
		}
	}
}