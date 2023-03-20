import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[][] arr;
	static int n;
	static int min;
	static boolean stop_find;
	static boolean[] visited;
	
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
		
		min = Integer.MAX_VALUE;
		stop_find = false;
		visited = new boolean[n];
		dfs(0, 0, new int[n/2]);
		System.out.println(min);
	}
	
	public static void dfs(int cnt, int last_idx, int[] chosen) {
		if(cnt >= chosen.length && stop_find == false) {
			int idx = 0;
			int[] chosen_2 = new int[n/2];
			for(int i=0; i<n; i++) {
				if(visited[i] == false) {
					chosen_2[idx] = i;
					idx++;
				}
			}
			int sum_chosen = 0;
			int sum_chosen_2 = 0;
			for(int i=0; i<chosen.length; i++) { // 1, 2, 3
				for(int j=0; j<chosen.length; j++) {
					if(i != j) {
						sum_chosen += arr[chosen[i]][chosen[j]];
						sum_chosen_2 += arr[chosen_2[i]][chosen_2[j]];
					}
				}
			}
			min = Math.min(min, Math.abs(sum_chosen_2 - sum_chosen));
			if(min == 0) stop_find = true;
		}
		else {
			for(int i=last_idx; i<n; i++) {
				if(stop_find == false) {
					chosen[cnt] = i;
					visited[i] = true; // visited 배열을 주어 반복된 연산을 줄여주어 메모리와 시간을 절약한다!
					dfs(cnt+1, i+1, chosen);
					chosen[cnt] = 0;
					visited[i] = false;
				}
			}
		}
	}
}