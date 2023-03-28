import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int[] arr_num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] left = new int[n];
		for(int i=0; i<n; i++) {
			left[i] = i+1;
		}
		dfs(0, new int[m], left);
		System.out.println(sb);
	}
	public static void dfs(int cnt, int[] chosen, int[] left) {
		if(cnt >= m) {
			for(int i=0; i<m; i++) {
				sb.append(chosen[i] + " ");
			}
			sb.append("\n");
		}
		else {
			for(int i=0; i<n; i++) {
				if(left[i] != -1) {
					int temp = left[i];
					chosen[cnt] = left[i];
					left[i] = -1;
					dfs(cnt+1, chosen, left);
					left[i] = temp;
					chosen[cnt] = 0;
				}
			}
		}
	}
}