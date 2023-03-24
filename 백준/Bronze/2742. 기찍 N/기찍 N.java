import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			System.out.println(n-i);
		}
	}
}