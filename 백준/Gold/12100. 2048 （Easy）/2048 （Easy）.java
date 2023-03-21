import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] arr;
	static int max;
	static String[] direction = {"up","down","left","right"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		max = Integer.MIN_VALUE;
		for(int row=0; row<n; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<n; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[row][col]);
			}
		}
		
		dfs(0, new String[5]);
//		System.out.println(max); //    조심!!!!!!!!        max 값이 MIN_VALUE 그대로 출력될때 항상 생각해서 예외처리해주기!!!!!
		System.out.println(max);
	}
	
	// up,up,up,down,left
	public static void dfs(int cnt, String[] chosen) {
		if(cnt >= 5) {
			int[][] arr_copy = new int[n][n];
			for(int row=0; row<n; row++) {
				arr_copy[row] = Arrays.copyOf(arr[row], n);
			}
			for(int i=0; i<chosen.length; i++) {
				move(chosen[i], arr_copy);
			}
		}
		else {
			for(int i=0; i<direction.length; i++) {
				chosen[cnt] = direction[i];
				dfs(cnt+1, chosen);
				chosen[cnt] = "";
			}
		}
	}
	
	
	public static void move(String dir, int[][] arr_copy) {
		if(dir.equals("up")) {
			for(int col=0; col<n; col++) {
				int before_row = -1;
				int before_target = -1;
				for(int row=0; row<n; row++) {
					if(arr_copy[row][col] != 0) {
						int current_target = arr_copy[row][col];
						int current_row = row;
						if(before_target == current_target) {
							arr_copy[before_row][col] = before_target + current_target;
							arr_copy[current_row][col] = 0;
							max = Math.max(max, arr_copy[before_row][col]);
							before_row = -1;
							before_target = -1;
						}
						else {
							before_row = current_row;
							before_target = current_target;
						}
					}
				}
			}
			for(int col=0; col<n; col++) {
				for(int row=0; row<n; row++) {
					if(arr_copy[row][col] == 0) {
						for(int row_s=row+1; row_s<n; row_s++) {
							if(arr_copy[row_s][col] != 0) {
								arr_copy[row][col] = arr_copy[row_s][col];
								arr_copy[row_s][col] = 0;
								break;
							}
						}
					}
				}
			}
			
		}
		else if(dir.equals("down")) {
			for(int col=0; col<n; col++) {
				int before_row = -1;
				int before_target = -1;
				for(int row=n-1; row>=0; row--) {
					if(arr_copy[row][col] != 0) {
						int current_target = arr_copy[row][col];
						int current_row = row;
						if(before_target == current_target) {
							arr_copy[before_row][col] = before_target + current_target;
							arr_copy[current_row][col] = 0;
							max = Math.max(max, arr_copy[before_row][col]);
							before_row = -1;
							before_target = -1;
						}
						else {
							before_row = current_row;
							before_target = current_target;
						}
					}
				}
			}
			for(int col=0; col<n; col++) {
				for(int row=n-1; row>=0; row--) {
					if(arr_copy[row][col] == 0) {
						for(int row_s=row-1; row_s>=0; row_s--) {
							if(arr_copy[row_s][col] != 0) {
								arr_copy[row][col] = arr_copy[row_s][col];
								arr_copy[row_s][col] = 0;
								break;
							}
						}
					}
				}
			}
		}
		else if(dir.equals("left")) {
			for(int row=0; row<n; row++) {
				int before_col = -1;
				int before_target = -1;
				for(int col=0; col<n; col++) {
					if(arr_copy[row][col] != 0) {
						int current_target = arr_copy[row][col];
						int current_col = col;
						if(before_target == current_target) {
							arr_copy[row][before_col] = before_target + current_target;
							arr_copy[row][current_col] = 0;
							max = Math.max(max, arr_copy[row][before_col]);
							before_col = -1;
							before_target = -1;
						}
						else {
							before_col = current_col;
							before_target = current_target;
						}
					}
				}
			}
			for(int row=0; row<n; row++) {
				for(int col=0; col<n; col++) {
					if(arr_copy[row][col] == 0) {
						for(int col_s=col+1; col_s<n; col_s++) {
							if(arr_copy[row][col_s] != 0) {
								arr_copy[row][col] = arr_copy[row][col_s];
								arr_copy[row][col_s] = 0;
								break;
							}
						}
					}
				}
			}
		}
		else if(dir.equals("right")) {
			for(int row=0; row<n; row++) {
				int before_col = -1;
				int before_target = -1;
				for(int col=n-1; col>=0; col--) {
					if(arr_copy[row][col] != 0) {
						int current_target = arr_copy[row][col];
						int current_col = col;
						if(before_target == current_target) {
							arr_copy[row][before_col] = before_target + current_target;
							arr_copy[row][current_col] = 0;
							max = Math.max(max, arr_copy[row][before_col]);
							before_col = -1;
							before_target = -1;
						}
						else {
							before_col = current_col;
							before_target = current_target;
						}
					}
				}
			}
			for(int row=0; row<n; row++) {
				for(int col=n-1; col>=0; col--) {
					if(arr_copy[row][col] == 0) {
						for(int col_s=col-1; col_s>=0; col_s--) {
							if(arr_copy[row][col_s] != 0) {
								arr_copy[row][col] = arr_copy[row][col_s];
								arr_copy[row][col_s] = 0;
								break;
							}
						}
					}
				}
			}
		}
	}
}