import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<int[]> list;
	static ArrayList<int[]> list2;
	static int[][] arr;
	static int min;
	static boolean[][] possible;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		
		arr = new int[n][n];
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<n; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c] == 1) {
					list.add(new int[] {r,c}); // 1의 위치를 저장.
				}
				else if(arr[r][c] == 2) {
					list2.add(new int[] {r,c});
				}
			}
		}
		
		// 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
		
		// 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 
		// 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램
		
		// 0. 1의 위치를 모두 저장.
		// 저장된 1의 위치 중에서 M개를 조합해서 고름
		// dfs 실행. list.size 중에서 M개를 조합 (조합된 M개의 인덱스 반환)
		dfs(0, 0, new int[m]);
		
		
		// 골라진 M개에서 아래를 실행.
		
		// 1. arr 배열에서 1 을 기준으로, 가장 가까운 2를 조사해서, 거리를 입력. (bfs 로 최단거리 조사)
		// chick_dist 배열에 그 좌표에 그 값을 저장.
		
		// 도시 치킨 거리를 구한다. ( 총 합 )
		// 도시 치킨 거리의 최소값을 갱신한다.
		// 끝나면 최소값을 출력한다.
		System.out.println(min);
	}
	
	public static int bfs(int row, int col) {
		int distance = 0;
		boolean[][] visited = new boolean[n][n];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row, col, 0});
		visited[row][col] = true;
		
		Loop1: while(!q.isEmpty()) {
			
			int[] popped = q.poll();
			int popped_row = popped[0];
			int popped_col = popped[1];
			int popped_dist = popped[2];
			
			for(int i=0; i<4; i++) {
				int nr = popped_row + dr[i];
				int nc = popped_col + dc[i];
				
				if(bc(nr,nc) == true && visited[nr][nc] == false) {
					
					if(arr[nr][nc] == 2 && possible[nr][nc] == true) {
						distance = popped_dist + 1;
						break Loop1;
					}
					
					q.add(new int[] {nr,nc,popped_dist+1});
					visited[nr][nc] = true;
					
				}
				
			}
			
			
		}
		
		return distance;
		
	}
	
	
	public static void dfs(int cnt, int last_idx, int[] chosen) {
		
		if(cnt >= m) {
			possible = new boolean[n][n];
			int sum_city = 0;
//			System.out.println(Arrays.toString(chosen));
			for(int i=0; i<chosen.length; i++) {
				int idx = chosen[i];
//				System.out.println(Arrays.toString(list2.get(idx)));
				int target_row = list2.get(idx)[0];
				int target_col = list2.get(idx)[1];
				
				possible[target_row][target_col] = true;
				
				
			}
			
			for(int i=0; i<list.size(); i++) {
				int dist = bfs(list.get(i)[0], list.get(i)[1]);
//				System.out.println(dist);
				sum_city += dist;
			}
			
				
				
				
//				for(int r=0; r<n; r++) {
//					for(int c=0; c<n; c++) {
//						int dist = bfs(list.get(idx)[0], list.get(idx)[1]);
//					}
//				}
				
//			System.out.println(sum_city);
			min = Math.min(min, sum_city);
			
		}
		
		else {
			for(int i=last_idx; i<list2.size(); i++) {
				
				chosen[cnt] = i;
				dfs(cnt+1, i+1, chosen);
				chosen[cnt] = 0;
				
			}
		}
		
	}
	
	public static int sum_arr(int[][] arr) {
		int sum = 0;
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				sum += arr[r][c];
			}
		}
		return sum;
	}
	
	public static boolean bc(int row, int col) {
		if(row>=0 && row<n && col>=0 && col<n) return true;
		else return false;
	}
	
	public static void printarr(int[][] arr) {
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}