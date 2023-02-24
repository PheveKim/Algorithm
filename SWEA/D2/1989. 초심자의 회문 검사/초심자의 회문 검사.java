import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			
			String str = br.readLine();
			String front = "";
			String back = "";
			if(str.length() % 2 != 0) {
				front = str.substring(0, str.length()/2);
				back = str.substring(str.length()/2+1, str.length());
			} else {
				front = str.substring(0, str.length()/2);
				back = str.substring(str.length()/2, str.length());
			}
			String front_backward = "";
			for(int i=front.length()-1; i>=0; i--) {
				front_backward += front.substring(i, i+1);
			}
			int answer = 0;
			if(front_backward.equals(back)) answer = 1;
			System.out.println("#" + (t+1) + " " + answer);
			
		}
	}
}