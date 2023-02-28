import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {
	
	static int[][] arr;
	static int start_row;
	static int start_col;
	static int[] dr = {-1, 1, 0, 0};  // 상하좌우 순으로 탐색합니다.
	static int[] dc = {0, 0, -1, 1};  // 하지만 이 문제의 경우 하우좌상 순서로 탐색하면 실행속도가 빨라집니다.
	static boolean found;             // 174ms -> 144ms
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int t = 0; t < 10; t++) {

			int tc = Integer.parseInt(br.readLine().trim());
			arr = new int[16][16];
			boolean[][] visited = new boolean[16][16]; // 한번 갔던길은 다시 안가기 위해 visited 배열을 선언합니다.
			for(int row=0; row<16; row++) {
				String str = br.readLine();
				for(int col=0; col<16; col++) {
					arr[row][col] = Integer.parseInt(str.substring(col, col+1)); // 배열을 저장합니다.
					if(arr[row][col] == 2) { // 시작 지점을 기억해 놓습니다.
						start_row = row;
						start_col = col;
					}
				}
			}
			
			found = false; // 초기 조건은 못찾았음으로 줍니다,.
			dfs(start_row, start_col, visited); // dfs 를 시작합니다.
			
			if(found) System.out.println("#" + (t+1) + " " + 1); // 결과를 출력합니다.
			else System.out.println("#" + (t+1) + " " + 0);
		}
	}
	
	public static void dfs(int row, int col, boolean[][] visited) {
		visited[row][col] = true; // 들어온 row와 col 좌표에 visited를 true로 표시해줍니다.
		
		if(found == false) { // 만약 아직 발견되지 않았다면 (found 는 글로벌변수이므로 한번 찾으면 나머지는 모두 탈출합니다.)
			for(int i=0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr>=0 && nr<16 && nc>=0 && nc<16) { // 바운더리 만족 시,
					if((arr[nr][nc] == 0 || arr[nr][nc] == 3) && visited[nr][nc] == false) { // 길이 나있거나, 3 일때, 방문하지 않았어야 진행합니다.
						if(arr[nr][nc] == 3) found = true; // 만약 3을 보면 found를 true로 해줍니다.
						dfs(nr, nc, visited); // dfs함수를 재귀호출해줍니다.
						visited[nr][nc] = false; // 재귀가 빠져나올때 다시 visited를 false로 바꿔주어야 이후 재귀호출시에 (4방탐색) 에 영향을 주지않습니다.
					}
				}
			}
		}
	}
}