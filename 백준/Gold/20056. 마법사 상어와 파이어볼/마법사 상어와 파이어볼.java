import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[] dir_r = {-1,-1,0,1,1,1,0,-1};
	static int[] dir_c = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ArrayList<int[]>[][] arr = new ArrayList[n][n];
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				arr[r][c] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr[r][c].add(new int[] {m,s,d});
		}
		
		// 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
		//	    이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
		// 파이어볼 이동 메서드
		
		// 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
		//    같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
		//    파이어볼은 4개의 파이어볼로 나누어진다.
		// (2개이상파이어볼) 파이어볼 합쳐지고 나누어지는 메서드
		
		//    나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
		// 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
		// 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
		// 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
		// 질량이 0인 파이어볼은 소멸되어 없어진다.
		
		// 마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 구해보자.
		// 파이어볼 질량 합 메서드
		
		int sum = 0;
		for(int i=0; i<k; i++) {
			
			ArrayList<int[]>[][] arr_moved = move_fireball(arr);
			
			ArrayList<int[]>[][] arr_fused = fusion_fireball(arr_moved);
			
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
//					arr[r][c].clear();  //  안해줘도 됨!!
					arr[r][c] = (ArrayList<int[]>) arr_fused[r][c].clone();
				}
			}
			
			if(i==k-1) {
				sum = sum_fireball(arr);
			}
		}
		System.out.println(sum);
		
	}

	public static ArrayList<int[]>[][] move_fireball(ArrayList<int[]>[][] arr){
		ArrayList<int[]>[][] arr_return = new ArrayList[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				arr_return[r][c] = new ArrayList<>();
			}
		}
		
		// 1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				
				for(int i=0; i<arr[r][c].size(); i++) {
					int[] fireball = arr[r][c].get(i);
					int m = fireball[0];
					int s = fireball[1];
					int d = fireball[2];
					
					// s = s % n; /////////////// 잘못!!!!!!!!!!!!!!
					////////////////////////// 원본값  속력으로 합을 구해야한다 !!!!!!
					////////////////////////// 임의대로 나눈값 속력으로 합을 구한게 잘못!!!!!!!!!
					
					int nr = r + dir_r[d] * (s%n);
					int nc = c + dir_c[d] * (s%n);
					
					if(nr>=n) nr = nr % n;
					else if(nr<0) nr = nr + n;
					
					if(nc>=n) nc = nc % n;
					else if(nc<0) nc = nc + n;
					
					arr_return[nr][nc].add(new int[] {m, s, d});
					
				}
			}
		}
		// 이동 끝.
		
		return arr_return;
		
	}
	
	public static ArrayList<int[]>[][] fusion_fireball(ArrayList<int[]>[][] arr){
		ArrayList<int[]>[][] arr_return = new ArrayList[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				arr_return[r][c] = new ArrayList<>();
			}
		}
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(arr[r][c].size() >= 2) { // 개수가 2 이상일 때, 합치고 나눌거다.
					
					int m_sum = 0;
					int s_sum = 0;
					boolean all_odd = true;
					boolean all_even = true;
					for(int i=0; i<arr[r][c].size(); i++) {
						
						int[] fireball = arr[r][c].get(i);
						int m = fireball[0];
						int s = fireball[1];
						int d = fireball[2];
						
						m_sum += m;
						s_sum += s;
						if(d % 2 == 0) {
							all_odd = false;
						}
						else if(d % 2 == 1) {
							all_even = false;
						}
						
						
					}
					
					int new_m = m_sum / 5;
					int new_s = s_sum / arr[r][c].size();
					if(new_m != 0) {
						
						if(all_odd == true || all_even == true) {
							arr_return[r][c].add(new int[] {new_m, new_s, 0});
							arr_return[r][c].add(new int[] {new_m, new_s, 2});
							arr_return[r][c].add(new int[] {new_m, new_s, 4});
							arr_return[r][c].add(new int[] {new_m, new_s, 6});
						}
						else {
							arr_return[r][c].add(new int[] {new_m, new_s, 1});
							arr_return[r][c].add(new int[] {new_m, new_s, 3});
							arr_return[r][c].add(new int[] {new_m, new_s, 5});
							arr_return[r][c].add(new int[] {new_m, new_s, 7});
						}
						
					}
					
				}
				
				else if(arr[r][c].size() == 1) { // 빼먹음! 오류. 개수가 2이상이 아닐때도 그대로 복사해줘야함.
					int[] fireball = arr[r][c].get(0);
					arr_return[r][c].add(new int[] {fireball[0], fireball[1], fireball[2]});
				}
			}
		}
		
		return arr_return;
	}
	
	public static int sum_fireball(ArrayList<int[]>[][] arr) {
		int sum = 0;
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				
				for(int i=0; i<arr[r][c].size(); i++) {
					sum += arr[r][c].get(i)[0]; // 질량 합
				}
				
			}
		}
		
		return sum;
	}
	
	
	public static boolean bc(int row, int col) {
		if(row>=0 && row<n && col>=0 && col<n) return true;
		else return false;
	}
	public static void printarr(ArrayList<int[]>[][] arr) {
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				if(arr[r][c].size() > 0) {
					for(int i=0; i<arr[r][c].size(); i++) {
						System.out.print(Arrays.toString(arr[r][c].get(i)) + " ");
					}System.out.print("     ");
				}
				else {
					System.out.print(arr[r][c] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}