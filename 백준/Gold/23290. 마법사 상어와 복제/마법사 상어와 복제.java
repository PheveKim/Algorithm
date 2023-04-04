import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	static int[] dr_shark = {-1,0,1,0}; // 상좌하우 0123
	static int[] dc_shark = {0,-1,0,1};
	static int[] dr_fish = {0,-1,-1,-1,0,1,1,1};
	static int[] dc_fish = {-1,-1,0,1,1,1,0,-1};
	static ArrayList<Integer>[][] arr;
	static int[][] smell;
	
	static int m;
	static int s;
	
	static int shark_r;
	static int shark_c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 상어가 이동할수 있는 경우의수 모두 구해놓기 (상상상 ~ 우우우)
		// 상좌하우 = 1234
		int[][] shark_d = new int[64][3];
		int idx = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<4; k++) {
					shark_d[idx] = new int[] {i,j,k};
					idx++;
				}
			}
		}
		
		// 가장 왼쪽 윗칸이 (1,1)
		// 가장 오른쪽 아랫칸이 (4,4)
		arr = new ArrayList[4][4]; // 다 0으로 초기화하고, 물고기를 의미하는 각 방향을 저장. + 상어 위치 저장.
		smell = new int[4][4];
		for(int row=0; row<4; row++) {
			for(int col=0; col<4; col++) {
				arr[row][col] = new ArrayList<>();
			}
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			arr[r][c].add(d);
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		arr[r][c].add(9);
		
		shark_r = r;
		shark_c = c;
		
		int fish_cnt = 0;
		for(int S=0; S<s; S++) {
			// 1. 상어가 모든 물고기에게 복제 마법을 시전.
			// 복제 시작.
			ArrayList<Integer>[][] arr_copy = new ArrayList[4][4];
			ArrayList<Integer>[][] arr_copy_temp = new ArrayList[4][4];
			for(int row=0; row<4; row++) {
				for(int col=0; col<4; col++) {
					arr_copy[row][col] = (ArrayList<Integer>) arr[row][col].clone();
					arr_copy_temp[row][col] = new ArrayList<>();
				}
			}
//			System.out.println("마법 연습 회차 : " + (S+1));
//			System.out.println("start");
//			printarr(arr_copy);
			
			
			// 2. 물고기가 이동.
			// 상어가 있는칸, BC 벗어나는칸, 물고기 냄새가 남아있는칸 엔 못감.
			// 갈 수 있는 칸이 없으면 반시계 방향으로 45도 회전한다.
			for(int row=0; row<4; row++) {
				for(int col=0; col<4; col++) {
					
					Loop1: for(int i=0; i<arr[row][col].size(); i++) {
						int d = arr[row][col].get(i);
						int d_start = d;
						if(d == 9) { // 상어면 물고기가 아니니까 패스.
//							shark_r = row;
//							shark_c = col;
							continue Loop1;
						}
						d++;
						int cnt = 0;
						boolean moved = false;
						Loop2: while(true) {
							if(cnt >= 8) {
								break Loop2;
							}
							cnt++;
							d--;
							if(d < 0) {
								d = d + 8;
							}
							int nr = row + dr_fish[d];
							int nc = col + dc_fish[d];
//							System.out.println(nr + " " + nc);
							if(bc(nr,nc) == true && smell[nr][nc] == 0) {
								if(nr == shark_r && nc == shark_c) {
									continue Loop2;
								}
//								if(arr[nr][nc].size() >= 1) {
//									if(arr[nr][nc].get(0) == 9) {
//										continue Loop2;
//									}
//								}
								arr_copy_temp[nr][nc].add(d);
								moved = true;
//								arr[row][col].remove(i);
//								arr[nr][nc].add(d);
								break Loop2;
							}
						}
						if(moved == false) {
							arr_copy_temp[row][col].add(d_start);
						}
						
					}
				}
			}
//			arr_copy_temp[shark_r][shark_c].add(9);
//			System.out.println("after fish move");
//			printarr(arr_copy_temp);
//			printarr2(smell);
			
			// 3. 상어 연속해서 3칸 이동.
			// 상하좌우로 이동가능.
			// 물고기를 먹으면, 물고기사라지고 냄새가 남음.
			// 먹을수있는 물고기가 가장많은 칸으로 이동.
			// 수가 같으면, 상하좌(132) < 하우하(343) 이기 떄문에 상하좌로 이동한다.
			
			int sr = 0;
			int sc = 0;
			int max = Integer.MIN_VALUE;
			int[][] smell_max = new int[4][4];
			ArrayList<Integer>[][] arr_max = new ArrayList[4][4];
			Loop1: for(int i=0; i<64; i++) {
				int[][] smell_copy = new int[4][4];
				for(int rr=0; rr<4; rr++) {
					smell_copy[rr] = Arrays.copyOf(smell[rr], 4);
				}
				ArrayList<Integer>[][] arr_copy2 = new ArrayList[4][4];
				for(int row=0; row<4; row++) {
					for(int col=0; col<4; col++) {
						arr_copy2[row][col] = (ArrayList<Integer>) arr_copy_temp[row][col].clone();
					}
				}
//				for(int t=0; t<arr_copy2[shark_r][shark_c].size(); t++) {
//					if(arr_copy2[shark_r][shark_c].get(t) == 9) {
//						arr_copy2[shark_r][shark_c].remove(t);
//						break;
//					}
//				}
//				arr_copy2[shark_r][shark_c].clear(); // 상어 제거
				int sum = 0;
				
				int nr = shark_r;
				int nc = shark_c;
				for(int j=0; j<3; j++) {
					int d = shark_d[i][j];
					nr += dr_shark[d];
					nc += dc_shark[d];
					
					if(bc(nr,nc) == false) {
						continue Loop1;
					}
					
					// 해당 물고기를 먹음. 물고기수를 셈. (최대로 먹어야하므로)
					if(arr_copy2[nr][nc].size() > 0) {
						sum += arr_copy_temp[nr][nc].size();
						smell_copy[nr][nc] = 3;
						arr_copy2[nr][nc].clear();
					}
				}
				if(max < sum) {
//					System.out.println(max + " " + sum);
					max = sum;
					for(int row=0; row<4; row++) {
						for(int col=0; col<4; col++) { // 초기화 안하고 복제해도 되는지?
							arr_max[row][col] = (ArrayList<Integer>) arr_copy2[row][col].clone();
							smell_max[row][col] = smell_copy[row][col];
						}
					}
//					System.out.println(nr+" "+nc);
					arr_max[nr][nc].add(9); // 최종위치에 상어 저장.
					sr = nr;
					sc = nc;
				}
			}
//			System.out.println("arr_max");
//			printarr(arr_max);
			
			shark_r = sr;
			shark_c = sc;
			
			
			// 4. 두번 전 연습에서 생긴 물고기 냄새가 사라짐
			// smell 값이 1 모두 감소.
			for(int row=0; row<4; row++) {
				for(int col=0; col<4; col++) {
					if(smell[row][col] != smell_max[row][col]) {
						smell[row][col] = smell_max[row][col];
					}
					if(smell[row][col] > 0) {
						smell[row][col]--;	
					}
				}
			}
//			printarr2(smell);
			
			// 5. 1에서의 복제한 상태가 반영된다.
			if(S == s-1) {
				for(int row=0; row<4; row++) {
					for(int col=0; col<4; col++) {
						fish_cnt += arr_max[row][col].size();
						fish_cnt += arr_copy[row][col].size();
					}
				}
				fish_cnt -= 2;
			}
			for(int row=0; row<4; row++) {
				for(int col=0; col<4; col++) {
//					arr[row][col].clear();
					Loop1: for(int i=0; i<arr_copy[row][col].size(); i++) {
						if(arr_copy[row][col].get(i) == 9) { // 상어면 복제 반영 안함.
							continue Loop1;
						}
						arr_max[row][col].add(arr_copy[row][col].get(i));
					}
					arr[row][col] = (ArrayList<Integer>) arr_max[row][col].clone();
				}
			}
			
			
			
//			System.out.println("final");
//			printarr(arr);
//			printarr2(smell);
//			System.out.println(fish_cnt);
		}
		System.out.println(fish_cnt);
		
	}
	
	public static void printarr(ArrayList[][] arr) {
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void printarr2(int[][] arr) {
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean bc(int row, int col) {
		if(row>=0 && row<4 && col>=0 && col<4) return true;
		else return false;
	}
	
	public static int to_dec(int[] input) {
		int n = 0;
		for(int i=0; i<3; i++) {
			n += input[i] * Math.pow(10, 3-i-1);
		}
		return n;
	}
}