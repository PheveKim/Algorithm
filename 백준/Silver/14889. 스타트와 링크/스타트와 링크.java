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
	static int min;
	static int sum_all;
	static boolean stop_find;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int row=0; row<n; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<n; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		sum_all = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i != j) {
					sum_all += arr[i][j];
				}
			}
		}
		min = Integer.MAX_VALUE;
		stop_find = false;
		dfs(0, 0, new int[n/2]);
		System.out.println(min);
	}
	
	public static void dfs(int cnt, int last_idx, int[] chosen) {
		
		if(cnt >= chosen.length && stop_find == false) {
			int sum_chosen = 0;
			for(int i=0; i<chosen.length; i++) { // 1, 2, 3
				for(int j=0; j<chosen.length; j++) {
					if(i != j) {
						sum_chosen += arr[chosen[i]][chosen[j]];
					}
				}
			}
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				list.add(i);
			}
			for(int i=0; i<chosen.length; i++) {
				list.set(chosen[i], -1);
			}
			int sum_list = 0;
			for(int i=0; i<list.size(); i++) {
				for(int j=0; j<list.size(); j++) {
					if(i != j && list.get(i) >= 0 && list.get(j) >= 0) {
						sum_list += arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(sum_list - sum_chosen));
			if(min == 0) stop_find = true;
		}
		else {
			for(int i=last_idx; i<n; i++) {
				if(stop_find == false) {
					chosen[cnt] = i;
					dfs(cnt+1, i+1, chosen);
					chosen[cnt] = 0;
				}
			}
		}
	}
}