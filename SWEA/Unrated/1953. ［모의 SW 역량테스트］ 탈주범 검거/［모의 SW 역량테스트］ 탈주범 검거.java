import java.util.*;
import java.io.*;
import java.math.*;


public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N;
	static int M;
	static int L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			for(int row=0; row<N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int col=0; col<M; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			 
			// 얼핏 봤을때는. cnt == L 일때 visited == true 인 지점의 개수를 출력하는것 같다.
			boolean[][] visited_temp = new boolean[N][M];
			visited_temp[R][C] = true;
			visited[R][C] = true;
			
			dfs(R, C, 1, visited_temp);
			
			int visited_cnt = 0;
			for(int row=0; row<N; row++) {
				for(int col=0; col<M; col++) {
					if(visited[row][col] == true) visited_cnt++;
				}
			}
			
			bw.write("#" + (t+1) + " " + visited_cnt);
			bw.newLine();
			bw.flush();
		}
		
		
	}
	
	
	public static void dfs(int R, int C, int cnt, boolean[][] visited_temp) {
		
		int current = arr[R][C];
		
		if(cnt < L) {
			int[] dr = {};
			int[] dc = {};
			int[][] cant = {{}};
			if(current == 1) {
				dr = new int[] {-1,1,0,0};
				dc = new int[] {0,0,-1,1};
				cant = new int[][] {{3,4,7},{3,5,6},{2,6,7},{2,4,5}};
			}
			else if(current == 2) {
				dr = new int[] {-1,1};
				dc = new int[] {0,0};
				cant = new int[][] {{3,4,7},{3,5,6}};
			}
			else if(current == 3) {
				dr = new int[] {0,0};
				dc = new int[] {-1,1};
				cant = new int[][] {{2,6,7},{2,4,5}};
			}
			else if(current == 4) {
				dr = new int[] {-1,0};
				dc = new int[] {0,1};
				cant = new int[][] {{3,4,7},{2,4,5}};
			}
			else if(current == 5) {
				dr = new int[] {1,0};
				dc = new int[] {0,1};
				cant = new int[][] {{3,5,6},{2,4,5}};
			}
			else if(current == 6) {
				dr = new int[] {0,1};
				dc = new int[] {-1,0};
				cant = new int[][] {{2,6,7},{3,5,6}};
			}
			else if(current == 7) {
				dr = new int[] {-1,0};
				dc = new int[] {0,-1};
				cant = new int[][] {{3,4,7},{2,6,7}};
			}
			
			Loop1: for(int i=0; i<dr.length; i++) {
				int nr = R + dr[i];
				int nc = C + dc[i];
				int[] cant_chosen = cant[i];
				
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(arr[nr][nc] != 0 && visited_temp[nr][nc] == false) {
						for(int j=0; j<cant_chosen.length; j++) {
							if(arr[nr][nc] == cant_chosen[j]) {
								continue Loop1;
							}
						}
						visited_temp[nr][nc] = true;
						visited[nr][nc] = true;
						dfs(nr, nc, cnt+1, visited_temp);
						visited_temp[nr][nc] = false;
					}
				}
				
			}
		}
		
		
		
		
		
		
	}
	

}