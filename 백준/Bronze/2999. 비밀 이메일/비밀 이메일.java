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

		String str = br.readLine();
		int N = str.length();
		
		int R = 0;
		int C = 0;
		for(int i=1; i<N; i++) {
			if(N % i == 0) {
				if(i<=N/i) {
					R = i;
					C = N/i;
				}
			}
		}
		
		String[][] arr = new String[R][C];
		
		int cnt = 0;
		Loop1: for(int col=0; col<C; col++) {
			for(int row=0; row<R; row++) {
//				if(cnt >= N) break Loop1;
				arr[row][col] = str.substring(cnt, cnt+1);
				cnt++;
			}
		}
//		System.out.println(Arrays.deepToString(arr));
		if(N == 1) System.out.println(str);
		else {
			for(int row=0; row<R; row++) {
				for(int col=0; col<C; col++) {
					System.out.print(arr[row][col]);
				}
			}
		}
		
	
	}
}