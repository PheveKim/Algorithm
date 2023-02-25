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
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());

			// 1/23 ~ 5/23
			int days = 0;
			int month = m1;
			for (int i = m1; i <= m2; i++) {
				if (month == m2) {
					if (m1 == m2) {
						days += d2 - d1 + 1;
					} else {
						days += d2;
					}
				} else {
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
						if (month == m1) {
							days += 31 - d1 + 1;
						} else {
							days += 31;
						}
					} else if (month == 2) {
						if (i == m1) {
							days += 28 - d1 + 1;
						} else {
							days += 28;
						}
					} else {
						if (month == m1) {
							days += 30 - d1 + 1;
						} else {
							days += 30;
						}
					}
					month++;
				}
			}
			System.out.println("#" + (t + 1) + " " + days);

		}
	}
}