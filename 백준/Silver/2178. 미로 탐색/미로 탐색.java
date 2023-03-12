import java.util.*;
import java.io.*;

public class Main {
	static int min;
	static int N;
	static int M;
	static int[][] arr = new int[N][M];
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int row=0; row<N; row++) {
			String str = br.readLine();
			for(int col=0; col<M; col++) {
				arr[row][col] = Integer.parseInt(str.substring(col, col+1));
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min);
	}
	
	public static void bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] popped = q.poll();
			int popped_row = popped[0];
			int popped_col = popped[1];
			int popped_dis = popped[2];
			
			if(popped_row == N-1 && popped_col == M-1) min = popped_dis;
			
			for(int i=0; i<4; i++) {
				int nr = popped_row + dr[i];
				int nc = popped_col + dc[i];
				
				if(boundaryCheck(nr, nc) == true) {
					if(arr[nr][nc] == 1 && visited[nr][nc] == false) {
						q.add(new int[] {nr, nc, popped_dis + 1});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
	public static boolean boundaryCheck(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<M) return true;
		else return false;
	}
}