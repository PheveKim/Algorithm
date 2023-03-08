import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int N;
	static int[][] arr;
	static int house_cnt;
	static ArrayList<Integer> list;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		list = new ArrayList<>();
		for(int row=0; row<N; row++) {
			String str = br.readLine();
			for(int col=0; col<N; col++) {
				arr[row][col] = Integer.parseInt(str.substring(col, col+1));
			}
		}
		
		house_cnt = 0;
		
		bfs();
		
		Collections.sort(list);
		
		System.out.println(house_cnt);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		
	}
	
	
	public static void bfs() {
		
		boolean[][] visited = new boolean[N][N];
		
		for(int row=0; row<N; row++) {
			for(int col=0; col<N; col++) {
				if(arr[row][col] == 1 && visited[row][col] == false) {
					int house_size = 1;
					house_cnt++;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {row, col});
					visited[row][col] = true;
					
					while(!q.isEmpty()) {
						
						int[] popped = q.poll();
						int popped_row = popped[0];
						int popped_col = popped[1];
						
						
						for(int i=0; i<4; i++) {
							int nr = popped_row + dr[i];
							int nc = popped_col + dc[i];
							
							if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc] == false && arr[nr][nc] == 1) {
								q.add(new int[] {nr,nc});
								visited[nr][nc] = true;
								house_size++;
							}
						}
						
						
						
					}
					
					list.add(house_size);
				}
			}
		}
		
		
	}
	
		

}