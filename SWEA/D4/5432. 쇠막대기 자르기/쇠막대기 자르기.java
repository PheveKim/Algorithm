import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			String input = br.readLine();

			// String[] arr = new String[input.length()];
			String[] arr = new String[input.length()];

			for (int i = 0; i < arr.length; i++)
				arr[i] = input.substring(i, i + 1);
//
//			for (int i = 0; i < arr.length; i++) {
//				if (arr.get(i).equals("(") && arr.get(i + 1).equals(")")) {
//					arr.set(i, "_");
//					arr.remove(i + 1);
//				}
//			}

			int left_cnt = 0;
			int sum = 0;
			
			
			for (int i = 0; i < arr.length; i++) {

				String now = arr[i];
				String before = "";
				if(i==0) before = "";
				else before = arr[i-1];
				if(now.equals("(")) {
					left_cnt++;
					sum++;
				}
				else if(now.equals(")") && before.equals("(")) {
					left_cnt--;
					sum--;
					sum+=left_cnt;
				}
				else if (now.equals(")") && !before.equals("(")){
					left_cnt--;
				}
			
			}

			bw.write("#" + (t + 1) + " " + sum);
			bw.newLine();
			bw.flush();

		}

	}

}