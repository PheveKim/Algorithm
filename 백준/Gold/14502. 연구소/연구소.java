import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[][] arr;
	static int N;
	static int M;
	static ArrayList<int[]> list_2;
	static ArrayList<int[]> list_0;
	static int zero_cnt;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		list_2 = new ArrayList<>();
		list_0 = new ArrayList<>();
		zero_cnt = 0;
		for(int row=0; row<N; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int col=0; col<M; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 2) list_2.add(new int[] {row,col});
				else if(arr[row][col] == 0) {
					list_0.add(new int[] {row,col});
					zero_cnt++;
				}
			}
		}
		
		max = Integer.MIN_VALUE;
		choose(0, 0, new int[3]);
		System.out.println(max);
	}
	
	
	public static void choose(int cnt, int last_idx, int[] chosen) {
		
		if(cnt >= 3) {
			for(int i=0; i<chosen.length; i++) {
				int r = list_0.get(chosen[i])[0];
				int c = list_0.get(chosen[i])[1];
				arr[r][c] = 1;
			}
			
			boolean[][] visited = new boolean[N][M];
			int visit_cnt = 0;
			
			Queue<int[]> q = new LinkedList<>();
			for(int i=0; i<list_2.size(); i++) {
				int[] start = list_2.get(i);
				int start_row = start[0];
				int start_col = start[1];
				q.add(new int[] {start_row, start_col});
				visited[start_row][start_col] = true;
			}
			
				
			while(!q.isEmpty()) {
				
				int[] popped = q.poll();
				int popped_row = popped[0];
				int popped_col = popped[1];
				
				for(int j=0; j<4; j++) {
					int nr = popped_row + dr[j];
					int nc = popped_col + dc[j];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M) {
						if(visited[nr][nc] == false && arr[nr][nc] == 0) {
							q.add(new int[] {nr,nc});
							visited[nr][nc] = true;
							visit_cnt++;
						}
					}
				}
			}
				
			
			for(int i=0; i<chosen.length; i++) {
				int r = list_0.get(chosen[i])[0];
				int c = list_0.get(chosen[i])[1];
				arr[r][c] = 0;
			}
			
			max = Math.max(max, zero_cnt - visit_cnt - 3);
			
		}
		else {
			for(int i=last_idx; i<list_0.size(); i++) {
				chosen[cnt] = i;
				choose(cnt+1, i+1, chosen);
				chosen[cnt] = 0;
			}
		}
	}
}