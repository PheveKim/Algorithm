import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int n;
	static int[] start = new int[2];
	static int[] goal = new int[2];
	static int min;
	static boolean[][] visited;
	static int dr[] = {-2,-2,-1,-1,1,1,2,2};
	static int dc[] = {-1,1,-2,2,-2,2,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); 
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n][n];
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			goal[0] = Integer.parseInt(st.nextToken());
			goal[1] = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			bfs();
			System.out.println(min);
		}
	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start[0], start[1], 0});
		visited[start[0]][start[1]] = true;
		
		Loop1: while(!q.isEmpty()) {
			int[] popped = q.poll();
			int popped_row = popped[0];
			int popped_col = popped[1];
			int popped_cnt = popped[2];
			
			if(popped_row == goal[0] && popped_col == goal[1]) {
				min = popped_cnt;
				break;
			}
			
			for(int i=0; i<8; i++) {
				int nr = popped_row + dr[i];
				int nc = popped_col + dc[i];
				
				if(bc(nr, nc) == true && visited[nr][nc] == false) {
					q.add(new int[] {nr, nc, popped_cnt + 1});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static boolean bc(int row, int col) {
		if(row>=0 && row<n && col>=0 && col<n) return true;
		else return false;
	}
}