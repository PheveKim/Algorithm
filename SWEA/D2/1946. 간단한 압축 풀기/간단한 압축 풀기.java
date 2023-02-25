import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			String all = "";
			String answer = "";
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				String alphabet = st.nextToken();
				int count = Integer.parseInt(st.nextToken());

				for (int i = 0; i < count; i++) {
					all += alphabet;
				}
			}
			System.out.println("#" + (t + 1));
			for (int i = 1; i < all.length() + 1; i++) {
				System.out.print(all.substring(i - 1, i));
				if (i % 10 == 0)
					System.out.println();
			}
			System.out.println();
		}
	}
}