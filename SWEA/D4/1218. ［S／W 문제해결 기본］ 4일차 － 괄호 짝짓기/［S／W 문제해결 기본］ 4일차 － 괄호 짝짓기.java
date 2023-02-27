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

		for (int t = 0; t < 10; t++) {
			
			int N = Integer.parseInt(br.readLine().trim());
			String str = br.readLine();
			int answer = 0;
			
			int cnt_1 = 0;
			int cnt_2 = 0;
			int cnt_3 = 0;
			int cnt_4 = 0;
			for(int i=0; i<str.length(); i++) {
				String current = str.substring(i,i+1);
				if(current.equals("(")) cnt_1++;
				else if(current.equals("{")) cnt_2++;
				else if(current.equals("<")) cnt_3++;
				else if(current.equals("[")) cnt_4++;
				else if(current.equals(")")) cnt_1--;
				else if(current.equals("}")) cnt_2--;
				else if(current.equals(">")) cnt_3--;
				else if(current.equals("]")) cnt_4--;
				
				if(cnt_1==0 && cnt_2==0 && cnt_3==0 && cnt_4==0) answer = 1;
				else answer = 0;
			}
			
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
}