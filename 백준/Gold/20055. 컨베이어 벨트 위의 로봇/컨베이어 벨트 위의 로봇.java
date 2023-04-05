import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static int k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[][] belt = new int[2][n];
		int[] robot = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			belt[0][i] = Integer.parseInt(st.nextToken());
		}
		for(int i=n-1; i>=0; i--) {
			belt[1][i] = Integer.parseInt(st.nextToken());
		}
		
		int whole_cnt = 0;
		while(true) {
			whole_cnt++;
			rotate_belt(belt);
			rotate_robot(robot);
			
			for(int i=n-2; i>=0; i--) {
				int next_pos = i+1;
				if(robot[i] == 1 && robot[next_pos] != 1 && belt[0][next_pos] >= 1) {
					robot[next_pos] = 1; // 로봇 이동
					robot[i] = 0;
					belt[0][next_pos]--; // 벨트 내구도 1 감소
				}
			}
			robot[n-1] = 0; // 내리는 위치 로봇 제거
//			belt[0][n-1]++; // 내리는 위치 내구도 복구 ?? <-- 여기서 에러. 혼자만의 착각.
			
			if(belt[0][0] >= 1) { // 올리는 위치에 로봇 올림
				robot[0] = 1;
				belt[0][0]--;
			}
			
			int zero_cnt = count_zero(belt);
			if(zero_cnt >= k) break;
		}
		System.out.println(whole_cnt);
		
		// 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다. 
		// while 문 반복 ( 4번 조건 만족시 break)
		// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
		//    회전 메서드
		
		// 2. 가장 먼저 벨트에 올라간 로봇부터, 
		//    벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 
		//    만약 이동할 수 없다면 가만히 있는다.
		//    로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 
		//    그 칸의 내구도가 1 이상 남아 있어야 한다.
		//    로봇이 이동하고 도착한 칸의 내구도는 즉시 1만큼 감소한다.
		//    로봇 이동 메서드 + 내구도 감소 메서드
		
		// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		//    올리고 나면 내구도는 즉시 1만큼 감소한다.
		
		
		// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 
		//    그렇지 않다면 1번으로 돌아간다.
		//    if( count_zero >= k ) break;
		//	  내구도 0을 세는 메서드

		
		// 종료되었을 때 몇 번째 단계가 진행 중이었는지 구해보자. 
		// 가장 처음 수행되는 단계는 1번째 단계이다.
		// while문 반복 횟수 출력.
		
	}
	public static void rotate_belt(int[][] belt) {
		int last_val = belt[0][n-1];
		for(int i=n-1; i>=1; i--) {
			belt[0][i] = belt[0][i-1];
		}
		belt[0][0] = belt[1][0];
		for(int i=0; i<n-1; i++) {
			belt[1][i] = belt[1][i+1];
		}
		belt[1][n-1] = last_val;
	}
	public static void rotate_robot(int[] robot) {
		for(int i=n-1; i>=1; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = 0;
		robot[n-1] = 0;
	}
	public static int count_zero(int[][] belt) {
		int zero_cnt = 0;
		for(int r=0; r<belt.length; r++) {
			for(int c=0; c<belt[0].length; c++) {
				if(belt[r][c] == 0) zero_cnt++;
			}
		}
		return zero_cnt;
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