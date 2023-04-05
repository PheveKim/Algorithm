import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static int n;
	static int nsq;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		nsq = (int) Math.pow(n, 2);
		int[][] arr = new int[nsq+1][4];
		int[] student_order = new int[nsq];
		for(int r=0; r<nsq; r++) {
			st = new StringTokenizer(br.readLine());
			int student_num = Integer.parseInt(st.nextToken());
			for(int c=0; c<4; c++) {
				arr[student_num][c] = Integer.parseInt(st.nextToken());
			}
			student_order[r] = student_num;
		}
		
		int[][] seat = new int[n][n];
		
		for(int s=0; s<nsq; s++) {
			int student_num = student_order[s];
			int max_like = Integer.MIN_VALUE;
			int max_blank = Integer.MIN_VALUE;
			int target_r = -1;
			int target_c = -1;
			
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					
					if(seat[r][c] == 0) {
						int like_cnt = 0;
						int blank_cnt = 0;
						for(int i=0; i<4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							
							if(bc(nr,nc) == true) {
								
								if(seat[nr][nc] == 0) {
									blank_cnt++;
								}
								else {
									for(int j=0; j<4; j++) {
										if(seat[nr][nc] == arr[student_num][j]) {
											like_cnt++;
											break;
										}
									}
								}
							}
						}
						if(max_like < like_cnt) {
							max_like = like_cnt;
							max_blank = blank_cnt;
							target_r = r;
							target_c = c;
						}
						else if(max_like == like_cnt) {
							if(max_blank < blank_cnt) {
								max_blank = blank_cnt;
								target_r = r;
								target_c = c;
							}
						}
					}
				}
			}
			seat[target_r][target_c] = student_num;
		}
		int ans = point(seat, arr);
		System.out.println(ans);
		
		// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
		//    인접하다 = 상하좌우로 해당 번호가 있다.
		//    그러한 번호의 카운트수++
		//    max < like 이면, 그 위치가 목적위치가 되고, max = like 로 갱신.
		
		// 2. 1을 만족하는 칸이 여러 개이면, 
		//    인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
		//    max == likes 일때, blank 카운트수++ 로 비교
		//                       blank 가 더 많은쪽으로 목적위치 설정.
		//                       blank 가 같으면, 목적위치 변화없음. (먼저가 우선)
		
		// 3. 2를 만족하는 칸도 여러 개인 경우, 
		//    행의 번호가 가장 작은 칸으로, 
		//    그러한 칸도 여러 개이면 
		//    열의 번호가 가장 작은 칸으로 자리를 정한다.
		
		// 마지막 만족도 계산 메서드
		// 인접한 칸에 앉은 좋아하는 학생의 수
	}
	
	
	public static int point(int[][] arr, int[][] likes) {

		int ans = 0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				int student_num = arr[r][c];
				int cnt = 0;
				for(int i=0; i<4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(bc(nr, nc) == true) {
						for(int j=0; j<4; j++) {
							if(arr[nr][nc] == likes[student_num][j]) {
								cnt++;
								break;
							}
						}
					}
					
				}
				if(cnt == 1) ans += 1;
				else if(cnt == 2) ans += 10;
				else if(cnt == 3) ans += 100;
				else if(cnt == 4) ans += 1000;
			}
		}
		return ans;
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