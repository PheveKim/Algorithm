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
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				sum += arr[j];
			}
		}
		System.out.println(sum);
		
	}
}