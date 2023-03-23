import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int time;
	static int n;
	static boolean cant;
	static int start_row;
	static int start_col;
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	static int shark_size;
	static int eat_size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		ArrayList<int[]> list_fish = new ArrayList<>();
		for(int row=0; row<n; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<n; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if(arr[row][col] == 9) {
					start_row = row;
					start_col = col;
					arr[row][col] = 0;
				}
				if(arr[row][col] != 9 && arr[row][col] != 0) {
					list_fish.add(new int[] {row,col});
				}
			}
		}
		
		// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기,
		// 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
		// 자신의 크기와 같은 수의 물고리를 먹을때마다 크기가 1 증가한다. ex) 크기 2가 2마리먹으면 -> 크기 3이되고 0마리로갱신.
		// 더이상 먹을 수 있는게 없을때 그때까지의 시간을 출력.
		
		time = 0;
		shark_size = 2;
		eat_size = 0;
		cant = false;
		while(true) {
			if(cant == true) break;
			visited = new boolean[n][n];
			bfs();
		}
		System.out.println(time);
	}
	
	public static void bfs() {
		
		cant = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start_row, start_col, 0});
		visited[start_row][start_col] = true;
		
		ArrayList<int[]> list_food = new ArrayList<>();
		Loop1: while(!q.isEmpty()) {
			int[] popped = q.poll();
			int popped_row = popped[0];
			int popped_col = popped[1];
			int popped_time = popped[2];
			for(int i=0; i<4; i++) {
				int nr = popped_row + dr[i];
				int nc = popped_col + dc[i];
				
				if(bc(nr,nc) == true) {
					if(visited[nr][nc] == false) {
						if(arr[nr][nc] < shark_size && arr[nr][nc] != 0) {
							cant = false;
							list_food.add(new int[] {nr, nc, popped_time + 1});
							visited[nr][nc] = true;
						}
						else if(arr[nr][nc] == shark_size || arr[nr][nc] == 0){
							q.add(new int[] {nr, nc, popped_time + 1});
							visited[nr][nc] = true;
						}
						else if(arr[nr][nc] > shark_size) {
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		int min_time = Integer.MAX_VALUE;
		int min_row = Integer.MAX_VALUE;
		int min_col = Integer.MAX_VALUE;
		int min_idx = 0;
		for(int i=0; i<list_food.size(); i++) {
			if(min_time > list_food.get(i)[2]) {
				min_time = list_food.get(i)[2];
				min_idx = i;
			}
			else if(min_time == list_food.get(i)[2]) {
				if(list_food.get(min_idx)[0] > list_food.get(i)[0]) {
					min_idx = i;
				}
				else if(list_food.get(min_idx)[0] == list_food.get(i)[0]) {
					if(list_food.get(min_idx)[1] > list_food.get(i)[1]) {
						min_idx = i;
					}
				}
			}
		}
		if(list_food.size() > 0) {
			time += list_food.get(min_idx)[2];
			arr[list_food.get(min_idx)[0]][list_food.get(min_idx)[1]] = 0;
			start_row = list_food.get(min_idx)[0];
			start_col = list_food.get(min_idx)[1];
			eat_size++;
			if(shark_size == eat_size) {
				shark_size++;
				eat_size = 0;
			}
		}
	}
	
	public static boolean bc(int row, int col) {
		if(row>=0 && row<n && col>=0 && col<n) return true;
		else return false;
	}
}