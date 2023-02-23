import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int t = 0; t < 10; t++) {

			int tc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int st_len = st.countTokens();

			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < st_len; i++) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}

			Loop1: while (true) {
				for (int i = 0; i < 5; i++) {
					int target = list.get(0);
					int new_val = target - (i + 1);
					if (new_val <= 0) {
						list.remove(0);
						list.add(0);
						break Loop1;
					}

					list.remove(0);
					list.add(new_val);
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}

	}

}