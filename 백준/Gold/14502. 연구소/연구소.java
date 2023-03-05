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
	static int max;
	static int zero_cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		list = new ArrayList<>();
		zero_cnt = 0;
		for(int row=0; row<N; row++) {
			st = new StringTokenizer(br.readLine());
			int st_len = st.countTokens();
			for(int col=0; col<M; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 2) {
					list.add(new int[] {row,col}); // 2 의 위치 저장.
				}
				else if(arr[row][col] == 0) {
					zero_cnt++;
				}
			}
		}
		
		
		// 임의의 세점을 뽑는 조합 제귀 후
		// 각 경우에 대해 2 를 기준으로 bfs 후에 남은 0의 개수 세기.

		// 2차원 배열에서 임의의 점 세개를 뽑는 조합?
		// 0 ~ 48 의 숫자중 임의로 세개를 뽑아서
		// ex) 4, 26, 45 이면,
		// (0,4), (3, 5), (6, 3) 이렇게. 굿.
		// ( num/M , num%M ) 으로 좌표로 변환함.
		
		max = Integer.MIN_VALUE;
		choose(0, 0, new int[3]);
		
		
		System.out.println(max);
	}
	
	public static void choose(int cnt, int last_idx, int[] chosen) {
		if(cnt > 2) {
			
			for(int i=0; i<chosen.length; i++) {
				int r = chosen[i] / M;
				int c = chosen[i] % M;
				
				arr[r][c] = 1;
			} // 벽으로 변환
			
			boolean[][] visited = new boolean[N][M];
			int visit_cnt = 0;
			// 2 기준 bfs 실행
			for(int i=0; i<list.size(); i++) {
				
				int[] start = list.get(i);
				Queue<int[]> q = new LinkedList<>();
				q.add(start);
				visited[start[0]][start[1]] = true;
				
				while(!q.isEmpty()) {
					
					int[] popped = q.poll();
					int popped_row = popped[0];
					int popped_col = popped[1];
					
					for(int k=0; k<4; k++) {
						int nr = popped_row + dr[k];
						int nc = popped_col + dc[k];
						
						if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc] == false && arr[nr][nc] == 0) {
							q.add(new int[] {nr,nc});
							visited[nr][nc] = true;
							visit_cnt++;
						}
					}
				}
			}
			
			max = Math.max(max, zero_cnt - visit_cnt - 3);
			
			
			
			
			
			
			for(int i=0; i<chosen.length; i++) {
				int r = chosen[i] / M;
				int c = chosen[i] % M;
				
				arr[r][c] = 0;
			} // 원래 땅으로 변환
			
		}
		
		else {
			for(int i=last_idx; i<N*M; i++) {
				
				if(arr[i/M][i%M] == 0) {
					chosen[cnt] = i;
					choose(cnt+1, i+1, chosen);
					chosen[cnt] = 0;
				}
				
			}
		}
		
	}
	
	public static void bfs() {
		
	}
	
}