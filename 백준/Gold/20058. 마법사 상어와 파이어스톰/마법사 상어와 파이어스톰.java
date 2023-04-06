import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static int q;
	static int m;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		m = (int) Math.pow(2, n);
		int[][] arr = new int[m][m];
		int[] L = new int[q];
		
		for(int r=0; r<arr.length; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<arr[0].length; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 이하 L 번 반복.
		int max_connected_cnt = 0;
		for(int i=0; i<L.length; i++) {
			// 1. 먼저 격자를 2^L × 2^L 크기의 부분 격자로 나눈다. 
			// 2. 그 후, 모든 부분 격자를 시계 방향으로 90도 회전시킨다.
			// 부분격자로 나누는 메서드 + 90도 시계방향 회전 메서드
			divide_and_rotate(arr, L[i]);
//			System.out.println("divide_and_rotate_complete");
//			printarr(arr);
			
			// 4. 이후 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다. 
			melt(arr);
//			System.out.println("melt complete");
//			printarr(arr);
			
			// 각 칸에서 bfs 때리는 메서드 -> 연결된 얼음(connected_count 가 4!! 보다 작은 좌표에 얼음 값 -1 한다.)
			// connected_count 의 최대값을 갱신하며 저장.
			max_connected_cnt = bfs(arr);
//			System.out.println("bfs complete");
//			printarr(arr);
		}
		
		
		
		// 끝나고 난뒤
		// arr 배열 모든 값 총합 출력
		int sum = sum_ice(arr);
		System.out.println(sum);
		
		// connected_count 출력
		if(max_connected_cnt < 2) max_connected_cnt = 0;
		System.out.println(max_connected_cnt);
		
		
	}
	
	public static void divide_and_rotate(int[][] arr, int l) {
		// 2^l * 2^l 크기로 격자를 나눔
		// 나눈 각 격자를 90도 시계방향으로 회전함.
		
		int new_len = (int) Math.pow(2, l);
		int count = arr.length / new_len;
		
		// 0 ~ 4 new_len*0 ~ new_len*1
		// 4 ~ 8 new_len*1 ~ new_len*2
		
		for(int R=0; R<count; R++) {
			for(int C=0; C<count; C++) {
				
				int[][] divided = new int[new_len][new_len];
				int DR = 0;
				int DC = 0;
				for(int r=new_len * R; r<new_len * (R+1); r++) {
					for(int c=new_len * C; c<new_len * (C+1); c++) {
						divided[DR][DC] = arr[r][c];
						DC++;
					}
					DR++;
					DC = 0;
				}
				DR = 0;
				
				// 부분격자 나누기 완료.
				// rotate 시작
				int[][] rotated = new int[new_len][new_len];
				rotated = rotate(divided);
				
				DR = 0;
				DC = 0;
				// 회전한 배열 원본 배열에 붙여넣기 하기.
				for(int r=new_len * R; r<new_len * (R+1); r++) {
					for(int c=new_len * C; c<new_len * (C+1); c++) {
						arr[r][c] = rotated[DR][DC];
						DC++;
					}
					DR++;
					DC = 0;
				}
				DR = 0;
			}
		}
		
	}
	public static int[][] rotate(int[][] arr){
		int[][] rotated_arr = new int[arr.length][arr[0].length];
		
		int len = arr.length;
		for(int c=0; c<len; c++) {
			for(int r=len-1; r>=0; r--) {
				rotated_arr[c][len-1-r] = arr[r][c];
			}
		}
		return rotated_arr;
	}
	
	public static void melt(int[][] arr) { /// 마지막에 틀린부분!!!!   바로 녹여서 갱신하는것이아니라, 좌표를 저장해놓고 한번에 갱신해야한다.
		ArrayList<int[]> melt_target = new ArrayList<>();
		for(int r=0; r<arr.length; r++) {  /// 왜냐하면 갱신된 값이 다음 조사때 영향을 주면 안되기 때문!!!!!!!!!
			for(int c=0; c<arr[0].length; c++) {
				if(arr[r][c] > 0) {
					int cnt = 0;
					for(int i=0; i<4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(bc(nr, nc) == true && arr[nr][nc] > 0) {
							cnt++;
						}
					}
					if(cnt < 3) {
						melt_target.add(new int[] {r, c});
					}
				}
			}
		}
		for(int i=0; i<melt_target.size(); i++) {
			arr[melt_target.get(i)[0]][melt_target.get(i)[1]]--;
		}
	}
	
	
	public static int bfs(int[][] arr) { // 문제 이해 잘못해서 bfs 만듬..!!!!!!!!! 인접한것만 보면되기때문에 사방탐색만 하면된다.
		int max_connected_cnt = 0;      // bfs 해서 계속 연결된것 조사하는게 아니다!!!!!!!!!
		
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
//				boolean[][] visited = new boolean[arr.length][arr[0].length];   // 이것때문에 시간초과!!! 어차피 연결되어있으면 다시조사할필요가없다.
				if(arr[r][c] > 0) { // 그 칸에 얼음이 있을때
					
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {r,c,1});
					visited[r][c] = true;
					
					int ice_cnt = 0;
					while(!q.isEmpty()) {
						ice_cnt++;
						int[] popped = q.poll();
						int popped_row = popped[0];
						int popped_col = popped[1];
						int popped_cnt = popped[2];
						
						for(int i=0; i<4; i++) {
							int nr = popped_row + dr[i];
							int nc = popped_col + dc[i];
							if(bc(nr, nc) == true && visited[nr][nc] == false && arr[nr][nc] > 0) {
								q.add(new int[] {nr, nc, popped_cnt + 1});
								visited[nr][nc] = true;
							}
						}
					}
					
//					if(part_max_cnt < 3) { // 얼음이 1 감소  // 이 부분이 잘못!!!!!!!!
//						for(int i=0; i<cords.size(); i++) {
//							arr[cords.get(i)[0]][cords.get(i)[1]]--;
//						}
//					}
					max_connected_cnt = Math.max(max_connected_cnt, ice_cnt); // 최대 연결 크기 갱신.
					
				}
				
			}
		}
		
		return max_connected_cnt;
	}
	public static int sum_ice(int[][] arr) {
		int sum = 0;
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				sum += arr[r][c];
			}
		}
		return sum;
	}
	public static boolean bc(int row, int col) { // 바운더리 체크 m 기준!
		if(row>=0 && row<m && col>=0 && col<m) return true;
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