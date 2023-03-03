import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int[][] arr;
	static boolean[] visited;
	static int V;
	static int E;
	static ArrayList<Integer> answer;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int t=0; t<10; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new int[V][V];
			visited = new boolean[V];
			answer = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			int from = -1;
			int to = -1;
			for(int i=0; i<2*E; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(i % 2 == 0) {
					from = num-1;
					to = -1;
				}
				else {
					to = num-1;
				}
				if(to != -1) arr[from][to] = 1;
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int col=0; col<V; col++) {
				boolean not_all_zero = false;
				for(int row=0; row<V; row++) {
					if(arr[row][col] != 0) not_all_zero = true;
				}
				if(!not_all_zero) {
					list.add(col);
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				answer.add(list.get(i)+1);
				visited[list.get(i)] = true;
				dfs(list.get(i));
			}
			
			bw.write("#" + (t+1) + " ");
			for(int i=0; i<V; i++) {
				bw.write(answer.get(i) + " ");
			}
			bw.newLine();
			bw.flush();
		}
	}
	
	
	public static void dfs(int from) {
		
		for(int col=0; col<V; col++) {
			if(arr[from][col] == 1 && visited[col] == false) {
				
				int coming_cnt = 0;
				ArrayList<Integer> coming_idx = new ArrayList<>();
				for(int row=0; row<V; row++) {
					if(arr[row][col] == 1) {
						coming_idx.add(row);
					}
				}
				
				int coming_false_cnt = 0;
				for(int j=0; j<coming_idx.size(); j++) {
					if(visited[coming_idx.get(j)] == false) {
						coming_false_cnt++;
					}
				}
				if(coming_false_cnt < 1) {
					visited[col] = true;
					answer.add(col+1);
					dfs(col);
				}
				
			}
		}
		
		
	}
	
}