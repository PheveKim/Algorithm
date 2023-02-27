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
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			String all = "";
			for(int i=0; i<N; i++) {
				all += str.substring(i, i+1);
			}
			
			boolean changed = true;
			while(true) {
				//ystem.out.println(all);
				if(changed == false) break;
				
				for(int i=1; i<all.length(); i++) {
					String before = all.substring(i-1, i);
					String current = all.substring(i, i+1);
					changed = false;
					if(before.equals(current)) {
						all = all.substring(0,i-1) + all.substring(i+1, all.length());
						changed = true;
						break;
					}
				}
			}
			
			
			System.out.println("#" + (t+1) + " " + all);
		}
	}
}