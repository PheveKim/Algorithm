import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {
	
	static int[][] arr;
	static int start_row;
	static int start_col;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean found;
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			
			String str = br.readLine();
			String current = "";
			String next = "";
			int cnt = 0;
			for(int i=0; i<str.length(); i++) {
				current = str.substring(i, i+1);
				if(i == str.length()-1)
					next = "";
				else
					next = str.substring(i+1, i+2);
				
				if(current.equals("(")) {
					if(next.equals("|") || next.equals(")")) {
						cnt++;
					}
				}
				else if(current.equals("|")) {
					if(next.equals(")")) {
						cnt++;
					}
				}
			}
			
			
			System.out.println("#" + (t+1) + " " + cnt);
		}
	}
}