import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0, 0, new int[m]);
	}
	public static void dfs(int cnt, int last_idx, int[] chosen) {
		if(cnt >= m) {
			for(int i=0; i<m; i++) {
				System.out.print(chosen[i] + " ");
			}
			System.out.println();
		}
		else {
			for(int i=last_idx; i<n; i++) {
				chosen[cnt] = arr[i];
				dfs(cnt+1, i+1, chosen);
				chosen[cnt] = 0;
			}
		}
	}
}