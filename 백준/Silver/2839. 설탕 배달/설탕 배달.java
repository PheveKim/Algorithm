package algorithm;

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int[][] arr;
	static int N;
	static int M;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
//		// 1) 직관적인 수학적 풀이
//		
//		// N = 5m + 3n 을 찾는데, m+n 이 최소가 되는 m+n 을 구해라.
//		// N / 5를 해서 -> 18 / 5 = 3.  -> 4부터 출발.
//		// m=4, x
//		// m=3, N - 15 = 3. = 3*1 -> n=1;
//		// m=2, N-10 = 8. cant
//		// m=1, N-5 = 13. cant
//		// m=0, N-0 = 18. n = 6;
//		
//		int m_max = N/5 + 1;
//		int min = Integer.MAX_VALUE;
//		int cnt = 0;
//		for(int m=m_max; m>=0; m--) {
//			int remainder = N - 5*m;
//			if(remainder >= 0) {
//				if(remainder == 0) {
//					cnt = m;
//					min = Math.min(min, cnt);
//				}
//				if(remainder % 3 == 0) {
//					int n = remainder / 3;
//					cnt = m + n;
//					min = Math.min(min, cnt);
//				}
//			}
//		}
//		
//		if(min == Integer.MAX_VALUE) min = -1;
//		System.out.println(min);
		
		
		// 2) 재귀 풀이
		
		// 5 와 3 중 재귀로 선택해서, 5m + 3n 이 N 을 넘어가는 순간 break.
		// N 과 같은 순간 그때 min 값 갱신.
		
		min = Integer.MAX_VALUE;
		choose(0, new int[2]);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	public static void choose(int cnt, int[] chosen) {
		
		if(cnt >= 2) {
			if(5*chosen[0] + 3*chosen[1] == N) {
				min = Math.min(min, chosen[0] + chosen[1]);
			}
		}
		
		else {
			for(int i=0; i<N/3+1; i++) {
				chosen[cnt] = i;
				choose(cnt+1, chosen);
				chosen[cnt] = 0;
			}
		}
		
			// !!! 주의 !!!
//			for(int i=0; i<2; i++) {    // 이렇게 하면 중복돼서 시간초과뜸.
//				if(i==0) choose(m+1, n);
//				if(i==1) choose(m, n+1);
//			}
			
			
	}
}










