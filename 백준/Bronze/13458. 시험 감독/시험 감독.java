import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		long all_cnt = 0;
		for(int i=0; i<n; i++) {
			arr[i] -= b;
			all_cnt++;
			if(arr[i] > 0) {
				long up = arr[i] / c;
				long left = arr[i] % c;
				if(left > 0) up++;
				all_cnt += up;
			}
		}
		
		System.out.println(all_cnt);
		
	}
}