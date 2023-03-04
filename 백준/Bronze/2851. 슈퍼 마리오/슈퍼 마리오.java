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
		
		int sum = 0;
		int[] arr = new int[10];
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			sum += num;
			arr[i] = sum;
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for(int i=0; i<10; i++) {
			if(min >= Math.abs(arr[i] - 100)) {
				min = Math.abs(arr[i] - 100);
				answer = arr[i];
			}
		}
		System.out.println(answer);
	}
}