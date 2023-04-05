import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static String[] dir = {"left", "down", "right", "up"};
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<n; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// wind 메서드 : 방향과(left, right, up, down) 좌표(y) 를 받아서, 10개의 좌표를 리턴.
		// 토네이도 진행 방향
		// left->down->right->up->left->down->right->up...
		// 1->1->2->2->3->3->4->4->5->5...
		
		// [n/2][n/2] 에서 출발 (중앙)
		int current_r = n/2;
		int current_c = n/2;
		int len = 1;
		int len_cnt = 0;
		int d = 0;
		
		int out_sand_all = 0;
		Loop1: while(true) {
			if(len_cnt == 2) {
				len++;
				len_cnt = 0;
			}
			
			d = d%4;
			String direction = dir[d];
			
			for(int dist=0; dist<len; dist++) {
				if(current_r == 0 && current_c == 0) break Loop1; // (1,1) 이면 끝
				int nr = current_r + dr[d];
				int nc = current_c + dc[d];
				
				int out_sand = wind(arr[nr][nc], nr, nc, direction, arr);
				current_r = nr;
				current_c = nc;
				out_sand_all += out_sand;
			}
			d++; // 다음 방향 진행.
			
			len_cnt++;
		}
		
		System.out.println(out_sand_all);
		
	}
	
	public static int wind(int sand, int row, int col, String direction, int[][] arr){
		
		// arr 배열에 흩어진 모래 반영하고,
		// 경계밖으로 나간 모래 개수 총합 리턴.
		int out_sand = 0;
		
		int[][] cords = new int[10][2];
		int[] percent_left = {2,10,7,1,5,0,10,7,1,2};
		int[] percent_right = {2,1,7,10,0,5,1,7,10,2};
		int[] percent_up = {5,10,0,10,2,7,7,2,1,1};
		int[] percent_down = {1,1,2,7,7,2,10,0,10,5};
		
		int alpha_idx = 0;
		int[] percent = new int[10];
		
		if(direction.equals("left")) {
			cords[0] = new int[] {row-2, col};
			cords[1] = new int[] {row-1, col-1};
			cords[2] = new int[] {row-1, col};
			cords[3] = new int[] {row-1, col+1};
			cords[4] = new int[] {row, col-2};
			cords[5] = new int[] {row, col-1};
			cords[6] = new int[] {row+1, col-1};
			cords[7] = new int[] {row+1, col};
			cords[8] = new int[] {row+1, col+1};
			cords[9] = new int[] {row+2, col};
			alpha_idx = 5;
			percent = Arrays.copyOf(percent_left, 10);
		}
		else if(direction.equals("right")) {
			cords[0] = new int[] {row-2, col};
			cords[1] = new int[] {row-1, col-1};
			cords[2] = new int[] {row-1, col};
			cords[3] = new int[] {row-1, col+1};
			cords[4] = new int[] {row, col+1};
			cords[5] = new int[] {row, col+2};
			cords[6] = new int[] {row+1, col-1};
			cords[7] = new int[] {row+1, col};
			cords[8] = new int[] {row+1, col+1};
			cords[9] = new int[] {row+2, col};
			alpha_idx = 4;
			percent = Arrays.copyOf(percent_right, 10);
		}
		else if(direction.equals("up")) {
			cords[0] = new int[] {row-2, col};
			cords[1] = new int[] {row-1, col-1};
			cords[2] = new int[] {row-1, col};
			cords[3] = new int[] {row-1, col+1};
			cords[4] = new int[] {row, col-2};
			cords[5] = new int[] {row, col-1};
			cords[6] = new int[] {row, col+1};
			cords[7] = new int[] {row, col+2};
			cords[8] = new int[] {row+1, col-1};
			cords[9] = new int[] {row+1, col+1};
			alpha_idx = 2;
			percent = Arrays.copyOf(percent_up, 10);
		}
		else if(direction.equals("down")) {
			cords[0] = new int[] {row-1, col-1};
			cords[1] = new int[] {row-1, col+1};
			cords[2] = new int[] {row, col-2};
			cords[3] = new int[] {row, col-1};
			cords[4] = new int[] {row, col+1};
			cords[5] = new int[] {row, col+2};
			cords[6] = new int[] {row+1, col-1};
			cords[7] = new int[] {row+1, col};
			cords[8] = new int[] {row+1, col+1};
			cords[9] = new int[] {row+2, col};
			alpha_idx = 7;
			percent = Arrays.copyOf(percent_down, 10);
		}
		
		arr[row][col] = 0; // 해당 위치(y) 의 모든 모래가 사라짐.
		int remain_sand = sand;
		for(int i=0; i<cords.length; i++) {
			if(i == alpha_idx) continue;
			int nr = cords[i][0];
			int nc = cords[i][1];
			if(bc(nr,nc) == true) {
				arr[nr][nc] += (sand * percent[i] / 100);
				remain_sand -= (sand * percent[i] / 100);
			}
			else {
				out_sand += (sand * percent[i] / 100);
				remain_sand -= (sand * percent[i] / 100);
			}
		}
		int nr = cords[alpha_idx][0];
		int nc = cords[alpha_idx][1];
		
		if(bc(nr,nc) == true) {
			arr[nr][nc] += remain_sand;
		}
		else {
			out_sand += remain_sand;
		}
		
		return out_sand;
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