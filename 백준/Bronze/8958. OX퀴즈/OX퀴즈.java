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
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			int cnt = 0;
			int sum = 0;
			for(int j=0; j<str.length(); j++) {
				String current = str.substring(j,j+1);
				if(current.equals("O")) {
					cnt++;
					sum += cnt;
				}
				else if(current.equals("X")) {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}
		
	}
}