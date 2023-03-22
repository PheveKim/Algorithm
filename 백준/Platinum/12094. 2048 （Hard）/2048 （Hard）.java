import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] arr;
	static int max;
	static String[] direction = {"up","down","left","right"};
	static boolean changed;
	static int[] max_arr;
	static int max_temp;
	
	public static void main(String[] args) throws IOException {
//		long startTime = System.nanoTime(); // 코드 시작 시간

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
		
		changed = false;
		max_arr = new int[10];
		dfs(0, arr);
//		System.out.println(max); //    조심!!!!!!!!        max 값이 MIN_VALUE 그대로 출력될때 항상 생각해서 예외처리해주기!!!!!
//		for(int i=0; i<10; i++) {
//			max = Math.max(max, max_arr[i]);
//		}
		bw.write(max + " ");
		bw.newLine();
		bw.flush();
//		System.out.println(max);
//		long endTime = System.nanoTime(); // 코드 끝난 시간
//		long durationTimeSec = endTime - startTime;
//		System.out.println(durationTimeSec/Math.pow(10, 9) + "s"); // 나노세컨드 출력
	}
	
	public static void dfs(int cnt, int[][] arr_input) {
		if(cnt < 10) {
			for(int i=0; i<direction.length; i++) {
				int[][] arr_copy = new int[n][n];
				max_temp = 2;
				for(int row=0; row<n; row++) {
//					arr_copy[row] = arr_input[row].clone();
					for(int col=0; col<n; col++) {
						arr_copy[row][col] = arr_input[row][col]; // clone() 이 더 빠른지?????????????????
						max_temp = Math.max(max_temp, arr_copy[row][col]);
					}
				}
				
				changed = false;
				move(direction[i], arr_copy);
//				max_temp = Math.max(max_temp, max_tempo);
//				if(changed == false && dir_before.equals(direction[i])) {}
//				else {
//					move(direction[i], arr_copy);
//				}
				if(changed == true) {
					if(max_arr[cnt] < max_temp) {
						max_arr[cnt] = max_temp;
						max = Math.max(max, max_arr[cnt]);
					}
					
					
					if(cnt+1 < 10) {
//						if(max_temp * 2 >= max_arr[cnt+1]) {
//							dfs(cnt+1, arr_copy, direction[i]);
//						}
						if(max_temp * Math.pow(2, 9-cnt) > max_arr[9]) {
							dfs(cnt+1, arr_copy);
						}
						else {
							break;
						}
					}
				}
			}
		}
	}
	
	public static void move(String dir, int[][] arr_copy) {
//		max_temp = 2;
		changed = false;
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
							max_temp = Math.max(max_temp, arr_copy[before_row][col]);
							changed = true;
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
								changed = true;
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
							max_temp = Math.max(max_temp, arr_copy[before_row][col]);
							changed = true;
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
								changed = true;
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
							max_temp = Math.max(max_temp, arr_copy[row][before_col]);
							changed = true;
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
								changed = true;
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
							max_temp = Math.max(max_temp, arr_copy[row][before_col]);
							changed = true;
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
								changed = true;
								break;
							}
						}
					}
				}
			}
		}
	}
}