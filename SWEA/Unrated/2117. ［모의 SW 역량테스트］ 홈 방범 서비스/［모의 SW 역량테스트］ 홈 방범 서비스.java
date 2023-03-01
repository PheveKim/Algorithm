import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int M;
	static int max_house;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			
			for(int row=0; row<N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int col=0; col<N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 운영 비용 = K*K + (K-1)*(K-1);
			// bfs 가 빠르기 때문에 bfs 를 할것임.
			// bfs 바운더리 조건에서, 출발지점과의 row값 차이 col값 차이가 (K-1) 이하일때만 밑을 실행.
			
			// 보안회사의 이익 = 집들로부터받는비용 - 운영비용
			// 보안회사의 이익 = 집수 * M - 운영 비용;
			// 보안회사의 이익이 0 이상일 때만고려. 즉, 보안회사의이익 < 0 인 순간 break.
			
			// 모든 지점에서 조사할 필요가 있다.
			// 조사하며 글로벌변수 max_house 를 누적갱신.
			max_house = 0;
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					visited = new boolean[N][N];
					int row_diff = Math.max(row+1, N-row-1);
					int col_diff = Math.max(col+1, N-col-1);
					int max_K = row_diff + col_diff - 1;
					bfs(row, col, max_K);
//					System.out.println(row + " " + col + " " + max_house);
				}
			}
//			bfs(6, 7);
			
			bw.write("#" + (t+1) + " " + max_house);
			bw.newLine();
			bw.flush();
		}
	}
	
	public static void bfs(int row, int col, int max_K) {
		
		int K = 1;
		
		Loop1: while(true) {
			
			if(K > max_K) break;
			visited = new boolean[N][N];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {row, col});
			visited[row][col] = true;
			int house_cnt = 0;
			
			while(!q.isEmpty()) {
				
				
				
				int[] popped = q.poll();
				int popped_row = popped[0];
				int popped_col = popped[1];
				
				if(arr[popped_row][popped_col] == 1) house_cnt++;
				
				for(int i=0; i<4; i++) {
					int nr = popped_row + dr[i];
					int nc = popped_col + dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc] == false) {
						if(Math.abs(nr-row) + Math.abs(nc-col) <= K-1) {
							q.add(new int[] {nr,nc});
							visited[nr][nc] = true;
//							System.out.println(Math.abs(nr-row) + Math.abs(nc-col) + "   " + (K-1));
//							for(int r=0; r<N; r++) {
//								for(int c=0; c<N; c++) {
//									if(visited[r][c]) System.out.print(1 + " ");
//									else System.out.print(0 + " ");
//								}
//								System.out.println();
//							}
//							System.out.println();
						}
					}
				}
			}
			int profit = house_cnt * M - (K*K + (K-1)*(K-1));
//			System.out.println(K + " " + house_cnt + " " + profit);
			if(profit >= 0) {
				max_house = Math.max(max_house, house_cnt);
			}
			K++;
		}
		
	}
}