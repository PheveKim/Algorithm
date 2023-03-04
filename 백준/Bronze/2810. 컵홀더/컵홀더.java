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

		int N = Integer.parseInt(br.readLine().trim());
		String str = br.readLine().trim();
		int answer = 0;
		int L_cnt = 0;
		for(int i=0; i<N; i++) {
			String current = str.substring(i,i+1);
			if(current.equals("L")) L_cnt++;
		}
		
		answer = 2 + N - 1 - (L_cnt/2);
		if(N==1) answer = 1;
		if(N==2) answer = 2;
		if(N==3) answer = 3;
		
		System.out.println(answer);
	}
}