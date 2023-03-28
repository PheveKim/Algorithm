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
		dfs(0, new int[m], arr);
	}
	public static void dfs(int cnt, int[] chosen, int[] left) {
		if(cnt >= m) {
			for(int i=0; i<m; i++) {
				System.out.print(chosen[i] + " ");
			}
			System.out.println();
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