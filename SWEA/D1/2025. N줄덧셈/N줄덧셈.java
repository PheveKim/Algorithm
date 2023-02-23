import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int num = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i=1; i<num+1; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		
	}

}