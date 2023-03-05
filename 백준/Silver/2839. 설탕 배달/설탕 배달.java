import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[][] arr;
	static int N;
	static int M;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// N = 5m + 3n 을 찾는데, m+n 이 최소가 되는 m+n 을 구해라.
		// N / 5를 해서 -> 18 / 5 = 3.  -> 4부터 출발.
		// m=4, x
		// m=3, N - 15 = 3. = 3*1 -> n=1;
		// m=2, N-10 = 8. cant
		// m=1, N-5 = 13. cant
		// m=0, N-0 = 18. n = 6;
		
		int m_max = N/5 + 1;
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		
		
		for(int m=m_max; m>=0; m--) {
			
			int remainder = N - 5*m;
			if(remainder >= 0) {
				if(remainder == 0) {
					cnt = m;
					min = Math.min(min, cnt);
				}
				if(remainder % 3 == 0) {
					int n = remainder / 3;
					cnt = m + n;
					min = Math.min(min, cnt);
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
		
		
	
	}
}