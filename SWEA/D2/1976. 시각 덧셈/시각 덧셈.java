import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			
			int h_answer = 0;
			if((h1 + h2 + (m1+m2)/60)%12 == 0) h_answer = 12;
			else h_answer = (h1 + h2 + (m1+m2)/60)%12;
			System.out.println("#" + (t+1) + " " + h_answer + " " + (m1+m2)%60);
			
		}
	}
}