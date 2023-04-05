import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] dir_r = {0,-1,-1,-1,0,1,1,1}; // 1이 0번째 인덱스.
	static int[] dir_c = {-1,-1,0,1,1,1,0,-1};
	static int[][] move;
	
	static int[] dr = {-1,-1,1,1};
	static int[] dc = {-1,1,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<n; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
//		printarr(arr);
		
		move = new int[m][2];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1; // 인덱스를 위한 -1
			int s = Integer.parseInt(st.nextToken());
		
			move[i][0] = d;
			move[i][1] = s;
		}
//		printarr(move);
		// 구름 시작 :  (N, 1), (N, 2), (N-1, 1), (N-1, 2)
		// m 번 동안 이동 : 방향 d 와 거리 s
		
		int[][] cloud = new int[n][n];
		cloud[n-1][0] = 2;
		cloud[n-1][1] = 2;
		cloud[n-2][0] = 2;
		cloud[n-2][1] = 2;
		
		for(int i=0; i<m; i++) {
			int direction = move[i][0];
			int distance = move[i][1];
			
			cloud_move(cloud, arr, direction, distance);
//			printarr(cloud);
//			printarr(arr);
			
			cloud_rain(cloud, arr);
//			printarr(cloud);
//			printarr(arr);
			
			cloud_disappear(cloud);
//			printarr(cloud);
//			printarr(arr);
			
			water_copy(cloud, arr);
//			printarr(cloud);
//			printarr(arr);
			
			cloud_make(cloud, arr);
//			printarr(cloud);
//			printarr(arr);
			
		}
		int ans = water_sum(arr);
		System.out.println(ans);
		// 1. 모든 구름이 d 방향으로 s칸 이동한다.
		// 구름 이동 메서드
		
		
		// 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
		// 구름인 배열 값 1 증가하는 메서드
		
		
		// 3. 구름이 모두 사라진다.
		// 구름이 사라지는 메서드
		
		
		// 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 
		//    대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
		//    이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
		//    예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, 
		//    (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.
		
		// 물복사 마법 메서드 ( 대각선 1칸 방향 물이 1이상인 칸의 수 만큼 물 증가 )
		
		
		// 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 
		// 중요) 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
		
		// 구름 생성 메서드
		
		
		// M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 구해보자.
		
		
	}
	
	// 구름 갓 생성된거는 2
	// 예전 구름은 1
	public static void cloud_move(int[][] cloud, int[][] arr, int direction, int distance) {
		int[][] new_cloud = new int[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(cloud[r][c] == 2) {
					distance = distance % n;
					int nr = r + dir_r[direction] * distance;
					int nc = c + dir_c[direction] * distance;
					
					if(nr >= n) {
						nr = nr % n;
					}
					else if(nr < 0) {
						nr = nr + n;
					}
					if(nc >= n) {
						nc = nc % n;
					}
					else if(nc < 0) {
						nc = nc + n;
					}
					new_cloud[nr][nc] = 2;
				}
			}
		}
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				cloud[r][c] = new_cloud[r][c];
			}
		}
	}
	public static void cloud_rain(int[][] cloud, int[][] arr) {
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(cloud[r][c] == 2) {
					arr[r][c]++;
				}
			}
		}
	}
	public static void cloud_disappear(int[][] cloud) {
		// 2인 구름이 1이 됨.
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(cloud[r][c] == 2) {
					cloud[r][c] = 1;
				}
			}
		}
	}
	public static void water_copy(int[][] cloud, int[][] arr) {
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(cloud[r][c] == 1) {
					int cnt = 0;
					for(int i=0; i<4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(bc(nr,nc) == true && arr[nr][nc] >= 1) {
							cnt++;
						}
					}
					arr[r][c] += cnt;
				}
			}
		}
	}
	public static void cloud_make(int[][] cloud, int[][] arr) {
		// cloud에 1인 구름 위치에는 2가 안생김
		// cloud에 2를 채움
		// cloud에 1을 제거함.
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(arr[r][c] >= 2 && cloud[r][c] != 1) {
					cloud[r][c] = 2;
					arr[r][c] -= 2;
				}
				else if(cloud[r][c] == 1) {
					cloud[r][c] = 0;
				}
			}
		}
	}
	public static int water_sum(int[][] arr) {
		int sum = 0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
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