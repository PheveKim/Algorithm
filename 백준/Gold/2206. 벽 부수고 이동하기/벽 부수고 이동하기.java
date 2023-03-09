import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int min;
	static ArrayList<Integer> list;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		list = new ArrayList<>();
		for(int row=0; row<N; row++) {
			String str = br.readLine();
			for(int col=0; col<M; col++) {
				arr[row][col] = Integer.parseInt(str.substring(col, col+1));
			}
		}
		
		min = Integer.MAX_VALUE;
		bfs();
		if(min == Integer.MAX_VALUE) min = -1;
		if(N==1 && M==1) min = 1;
		System.out.println(min);
	}
	
	
	public static void bfs() {
		
		boolean[][] visited = new boolean[N][M];
		boolean[][] visited_2 = new boolean[N][M];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1,1}); // row, col, distance, left_cnt
		visited[0][0] = true;
		
		
		while(!q.isEmpty()) {
//			System.out.println(q.toString());
			int[] popped = q.poll();
			int popped_row = popped[0];
			int popped_col = popped[1];
			int popped_distance = popped[2];
			int popped_left = popped[3];
			
			for(int i=0; i<4; i++) {
				int nr = popped_row + dr[i];
				int nc = popped_col + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					
					if(nr==N-1 && nc==M-1) {
						min = Math.min(min, popped_distance + 1);
					}
					
					else {
						
						if(popped_left == 0) {
							if(arr[nr][nc] == 0 && visited_2[nr][nc] == false) {
								q.add(new int[] {nr,nc,popped_distance+1, 0});
								visited_2[nr][nc] = true;
							}
						}
						else if(popped_left == 1) {
							if(arr[nr][nc] == 1 && visited[nr][nc] == false) {
								q.add(new int[] {nr,nc,popped_distance + 1, 0});
								visited[nr][nc] = true;
							}
							else if(arr[nr][nc] == 0 && visited[nr][nc] == false){
								q.add(new int[] {nr,nc,popped_distance + 1, 1});
								visited[nr][nc] = true;
							}
						}
						
					}
					
				}
			}
			
		}
		
		
		
		
		
		
		
	}
}