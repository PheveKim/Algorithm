import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static int n;
	static int m;
	static int cnt;
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine());
		int plus_cnt = Integer.parseInt(st.nextToken());
		int minus_cnt = Integer.parseInt(st.nextToken());
		int mul_cnt = Integer.parseInt(st.nextToken());
		int div_cnt = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(plus_cnt, minus_cnt, mul_cnt, div_cnt, 0, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int plus_cnt, int minus_cnt, int mul_cnt, int div_cnt, int cnt, int answer) {
		
		if(cnt == arr.length-1) {
			max = Math.max(max, answer);
			min = Math.min(min, answer);
		}
		else {
			if(plus_cnt > 0) dfs(plus_cnt-1, minus_cnt, mul_cnt, div_cnt, cnt+1, answer + arr[cnt+1]);
			if(minus_cnt > 0) dfs(plus_cnt, minus_cnt-1, mul_cnt, div_cnt, cnt+1, answer - arr[cnt+1]);
			if(mul_cnt > 0) dfs(plus_cnt, minus_cnt, mul_cnt-1, div_cnt, cnt+1, answer * arr[cnt+1]);
			if(div_cnt > 0) dfs(plus_cnt, minus_cnt, mul_cnt, div_cnt-1, cnt+1, answer / arr[cnt+1]);
		}
	}
}