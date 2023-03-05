import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[][] arr;
	static int N;
	static int M;
	static int min;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<int[]> list;
	static int zero_cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		list = new ArrayList<>();
		zero_cnt = 0;
		for(int row=0; row<N; row++) {
			st = new StringTokenizer(br.readLine());
			int st_len = st.countTokens();
			for(int col=0; col<N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 2) {
					list.add(new int[] {row,col,0}); // 2 의 위치 저장.
					zero_cnt++;
				}
				else if(arr[row][col] == 0) {
					zero_cnt++;
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		choose(0, 0, new int[M]);
		if(min == Integer.MAX_VALUE) min = -1;
		else if(min == Integer.MIN_VALUE) min = 0;
		System.out.println(min);
	}
	
	public static void choose(int cnt, int last_idx, int[] chosen) {
		if(cnt > M-1) {
			
			boolean[][] visited = new boolean[N][N];
			int visit_cnt = 0;
			int max_time = Integer.MIN_VALUE;
			
			Queue<int[]> q = new LinkedList<>();
			for(int i=0; i<chosen.length; i++) {
				int[] start = list.get(chosen[i]);
				q.add(start);
				visited[start[0]][start[1]] = true;
				visit_cnt++;
			}
			
			while(!q.isEmpty()) {
				
				int[] popped = q.poll();
				int popped_row = popped[0];
				int popped_col = popped[1];
				int popped_time = popped[2];
				
				for(int k=0; k<4; k++) {
					int nr = popped_row + dr[k];
					int nc = popped_col + dc[k];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc] == false && arr[nr][nc] != 1) {
						q.add(new int[] {nr,nc,popped_time+1});
						visited[nr][nc] = true;
						visit_cnt++;
						max_time = Math.max(max_time, popped_time+1);
					}
				}
			}
			
			if(visit_cnt == zero_cnt) min = Math.min(min, max_time);
			
		}
		
		else {
			for(int i=last_idx; i<list.size(); i++) {
				chosen[cnt] = i;
				choose(cnt+1, i+1, chosen);
				chosen[cnt] = 0;
			}
		}
	}
}