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
		
		
		int L = Integer.parseInt(br.readLine().trim());
		int[] cake = new int[L];
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] start = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			start[i] = to-from+1;
			
			for(int j=from; j<to+1; j++) {
				if(cake[j] == 0) {
					cake[j] = i+1;
				}
			}
			
		}
		
		int[] result = new int[N];
		for(int i=0; i<L; i++) {
			if(cake[i] != 0) {
				for(int j=0; j<N; j++) {
					if(cake[i] == (j+1)) {
						result[j]++;
					}
				}
			}
		}
		
		int max = 0;
		int max_idx = 0;
		int max_start = 0;
		int max_start_idx =0;
		for(int i=0; i<N; i++) {
			if(max < result[i]) {
				max = result[i];
				max_idx = i;
			}
			if(max_start < start[i]) {
				max_start = start[i];
				max_start_idx = i;
			}
		}
		
		System.out.println(max_start_idx+1);
		System.out.println(max_idx+1);
		
		
	
	}
}