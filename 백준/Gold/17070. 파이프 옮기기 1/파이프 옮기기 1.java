import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 0, 1};
	static int found;
	static int N;
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int row=0; row<N; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int col=0; col<N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		found = 0;
		visited[0][0] = true;
		visited[0][1] = true;
		dfs(0, 1, 0);
		System.out.println(found);
		
	}
	
	
	
	public static void dfs(int row, int col, int direction) {

		visited[row][col] = true;
		if(row == N-1 && col == N-1){
			found++;
		}
		
		else {
			int nr;
			int nc;
			
			if(direction == 0) {
				nr = row + dr[0];
				nc = col + dc[0];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(arr[nr][nc] != 1 && visited[nr][nc] == false) {
						dfs(nr, nc, 0);
						visited[nr][nc] = false;
					}
				}
				
				nr = row + dr[2];
				nc = col + dc[2];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(arr[row+1][col] != 1 && arr[row][col+1] != 1 && arr[nr][nc] != 1 && visited[nr][nc] == false) {
						dfs(nr, nc, 2);
						visited[nr][nc] = false;
					}
				}
			}
			else if(direction == 1) {
				nr = row + dr[1];
				nc = col + dc[1];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(arr[nr][nc] != 1 && visited[nr][nc] == false) {
						dfs(nr, nc, 1);
						visited[nr][nc] = false;
					}
				}
				
				nr = row + dr[2];
				nc = col + dc[2];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(arr[row+1][col] != 1 && arr[row][col+1] != 1 && arr[nr][nc] != 1 && visited[nr][nc] == false) {
						dfs(nr, nc, 2);
						visited[nr][nc] = false;
					}
				}
			}
			else if (direction == 2) {
				for(int i=0; i<3; i++) {
					nr = row + dr[i];
					nc = col + dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N) {
						if(i==2) {
							if(arr[row+1][col] != 1 && arr[row][col+1] != 1 && arr[nr][nc] != 1 && visited[nr][nc] == false) {
								dfs(nr, nc, 2);
								visited[nr][nc] = false;
							}
						}
						else {
							if(arr[nr][nc] != 1 && visited[nr][nc] == false) {
								dfs(nr, nc, i);
								visited[nr][nc] = false;
							}
						}
					}
				}
			}
			
		}
		
		
	}
	
}