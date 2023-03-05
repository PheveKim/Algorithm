import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[][] arr;
	static int N;
	static int M;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int cnt = 0;
		cnt += N; // 1개 짜리
		
		for(int i=2; i<N; i++) {
			
			int vert = i;
			boolean cant = true;
			while(true) {
				int total = i * vert;
				if(total <= N) {
					cnt++;
					vert++;
					cant = false;
				}
				else {
					break;
				}
			}
			if(cant == true) break;
		}
		
		System.out.println(cnt);
			
		
	}
}