import java.util.*;
import java.io.*;

public class Main {
	static int max;
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		int max_height = 0;
		for(int row=0; row<N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, arr[row][col]);
			}
		}
		max = 1; // 그 어느 지역도 물에 잠기지 않는 초기의 경우.
		for(int rain=1; rain<max_height+1; rain++) {
			visited = new boolean[N][N];
			bfs(rain);
		}
		System.out.println(max);
	}
	
	public static void bfs(int rain) {
		
		int safe_land = 0;
		for(int row=0; row<N; row++) {
			for(int col=0; col<N; col++) {
				if(visited[row][col] == false) {
					Queue<int[]> q = new LinkedList<>();
					if(arr[row][col] - rain > 0) {
						q.add(new int[] {row, col});
						visited[row][col] = true;
						safe_land++;
					}
					
					while(!q.isEmpty()) {
						int[] popped = q.poll();
						int popped_row = popped[0];
						int popped_col = popped[1];
						
						for(int i=0; i<4; i++) {
							int nr = popped_row + dr[i];
							int nc = popped_col + dc[i];
							if(boundaryCheck(nr, nc) == true && visited[nr][nc] == false && arr[nr][nc] - rain > 0) {
								q.add(new int[] {nr, nc});
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}
		max = Math.max(max, safe_land);
	}
	
	public static boolean boundaryCheck(int row, int col) {
		if(row>=0 && row<N && col>=0 && col<N) return true;
		else return false;
	}
}