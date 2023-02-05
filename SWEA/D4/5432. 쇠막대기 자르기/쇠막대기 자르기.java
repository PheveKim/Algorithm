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

			int left_cnt = 0;
			int sum = 0;

			for (int i = 0; i < input.length(); i++) {

				String now = input.substring(i, i + 1);
				String before = "";
				if (i == 0)
					before = "";
				else
					before = input.substring(i - 1, i);
				if (now.equals("(")) {
					left_cnt++;
					sum++;
				} else if (now.equals(")") && before.equals("(")) {
					left_cnt--;
					sum--;
					sum += left_cnt;
				} else if (now.equals(")") && !before.equals("(")) {
					left_cnt--;
				}

			}

			bw.write("#" + (t + 1) + " " + sum);
			bw.newLine();
			bw.flush();

		}

	}

}