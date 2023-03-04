import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int[] arr;
	static int N;
	static int M;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		max = Integer.MIN_VALUE;
		choose(0, 0, 0);
		
		System.out.println(max);
	}
	
	public static void choose(int cnt, int sum, int last_idx) {
		if(cnt >= 3) {
			max = Math.max(max, sum);
		}
		else {
			for(int i=last_idx; i<N; i++) {
				if(sum + arr[i] <= M) {
					choose(cnt+1, sum + arr[i], i + 1);
				}
			}
		}
	}
}