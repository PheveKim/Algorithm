import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int[][] arr;
	static int N;
	static int M;
	static int min_time;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] stairs;
	static int[] values;
	
	static ArrayList<Integer> list_1;
	static ArrayList<Integer> list_2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			stairs = new int[2][2];
			values = new int[2];
			int cnt = 0;
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
					if (arr[row][col] >= 2 && arr[row][col] <= 10) {
						stairs[cnt][0] = row;
						stairs[cnt][1] = col;
						values[cnt] = arr[row][col] + 1;
						cnt++;
					}
				}
			}

			// 이동 시간 : P와 S의 좌표값 차이의 절댓값.
			// 계단마다 K분이 걸림. (K = 2 ~ 10) 계단은 무조건 2개가 나옴.
			// 계단위에는 최대 3명
			// 계단입구에 도착후, 1분후에 내려갈수있다.
			// 모든 사람들이 계단을 내려가는 시간의 최소값이 되는 경우를 찾고, 그 시간을 출력.

			list_1 = new ArrayList<>();
			list_2 = new ArrayList<>();
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (arr[row][col] == 1) {
						int distance_1 = Math.abs(stairs[0][0] - row) + Math.abs(stairs[0][1] - col);
						int distance_2 = Math.abs(stairs[1][0] - row) + Math.abs(stairs[1][1] - col);
						list_1.add(distance_1);
						list_2.add(distance_2);
					}
				}
			}

			int list_size = list_1.size();
			min_time = Integer.MAX_VALUE;
			for(int i=0; i<list_size+1; i++) {
				int[] chosen_1 = new int[list_size];
				choose(i, 0, -1, chosen_1);
			}
			
			bw.write("#" + (t + 1) + " " + min_time);
			bw.newLine();
			bw.flush();
		}
	}

	
	
	public static void choose(int C, int cnt, int last_idx, int[] chosen_1) {
		
		if(cnt == C) {
			int[] chosen_2 = new int[list_2.size()];
			for(int i=0; i<chosen_2.length; i++) {
				if(chosen_1[i] == 0) chosen_2[i] = list_2.get(i);
			}
			
			// 이제 계단 시간 연산 시작.
			// 계단 모두 탈출 시 min_time 값 갱신.
			// chosen_1 : [0, 2, 2, 0, 5, 7]
			// chosen_2 : [4, 0, 0, 3, 0, 0]
			
//			Arrays.sort(chosen_1);  // sort 안해줘도 되더라.
//			Arrays.sort(chosen_2);
			// chosen_1 : [0,0,2,2,5,7]
			// chosen_2 : [0,0,0,0,3,4]
			
			boolean[] visited_1 = new boolean[chosen_1.length];
			boolean[] visited_2 = new boolean[chosen_2.length];
			int[] F1 = new int[3];
			int[] F2 = new int[3];
			int time = 0;
			while(true) {
				
				for(int i=0; i<3; i++) {
					F1[i]--;
					F2[i]--;
				}
				
				boolean stair_empty = true;;
				for(int i=0; i<3; i++) {
					if(F1[i] > 0) stair_empty = false;
					if(F2[i] > 0) stair_empty = false;
				}
				boolean all_visited = true;
				for(int i=0; i<visited_1.length; i++) {
					if(visited_1[i] == false) all_visited = false;
				    if(visited_2[i] == false) all_visited = false;
				}
//				System.out.println(Arrays.toString(visited_1));
				if(stair_empty && all_visited) {
					min_time = Math.min(min_time, time);
					break;
				}
				
				for(int i=0; i<chosen_1.length; i++) {
					if(chosen_1[i] == 0) visited_1[i] = true;
					if(visited_1[i] == false) {
						
						if(chosen_1[i] <= time) {
							for(int j=0; j<3; j++) {
								if(F1[j] <= 0) {
									if(chosen_1[i] == time) {
										F1[j] = values[0];
										visited_1[i] = true;
										break;
									}
									else if(chosen_1[i] < time) {
										F1[j] = values[0] - 1;
										visited_1[i] = true;
										break;
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i<chosen_2.length; i++) {
					if(chosen_2[i] == 0) visited_2[i] = true;
					if(visited_2[i] == false) {
						
						if(chosen_2[i] <= time) {
							for(int j=0; j<3; j++) {
								if(F2[j] <= 0) {
									if(chosen_2[i] == time) {
										F2[j] = values[1];
										visited_2[i] = true;
										break;
									}
									else if(chosen_2[i] < time) {
										F2[j] = values[1] - 1;
										visited_2[i] = true;
										break;
									}
								}
							}
						}
						
					}
				}
				time++;
			}
		}
		
		else {
			// C 개를 임의로 뽑는 경우의수 (재귀)
			for(int i=last_idx+1; i<list_1.size(); i++) {
				chosen_1[i] = list_1.get(i);
				choose(C, cnt+1, i, chosen_1);
				chosen_1[i] = 0; // 백트래킹 해줘야함.
			}
		}
	}
}