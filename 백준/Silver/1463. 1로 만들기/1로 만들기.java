import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int min_cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		
		min_cnt = Integer.MAX_VALUE;
		dfs(n, 0);
		System.out.println(min_cnt);
		
		
	}
	
	
	public static void dfs(int num, int cnt) {
		
		if(cnt >= min_cnt) { 
			return;
		}
		
		if(num == 1) {
			
			min_cnt = Math.min(min_cnt, cnt);
			
		}
		
		else if(num == 0) {
			return;
		}
		
		else {
			if(num%3 == 0) {
				dfs(num/3, cnt+1);
			}
			if(num%2 == 0) {
				dfs(num/2, cnt+1);
			}
			dfs(num-1, cnt+1);
		}
	}
}