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

			int start_idx = -1;
			int cnt = 0;

			for (int i = 0; i < input.length(); i++) {
				if (input.substring(i, i + 1).equals("1")) {
					start_idx = i;
					break;
				}
			}

			if (start_idx != -1) {
				cnt = 1;
				String before = input.substring(start_idx, start_idx + 1);

				for (int i = start_idx; i < input.length(); i++) {
					if (!input.substring(i, i + 1).equals(before)) {
						before = input.substring(i, i + 1);
						cnt++;
					}
				}
			}

			bw.write("#" + (t + 1) + " " + cnt);
			bw.newLine();
			bw.flush();

		}

	}

}