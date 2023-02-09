import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	static int N, L, max_point;
	static int[][] all;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			all = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				all[i][0] = Integer.parseInt(st.nextToken());
				all[i][1] = Integer.parseInt(st.nextToken());
			}

			max_point = 0;
			Select(0, 0, 0);

			bw.write("#" + (t + 1) + " " + max_point);
			bw.newLine();
			bw.flush();

		}

	}

	public static void Select(int idx, int point, int cal) {

		if (cal > L)
			return;
		if (cal <= L)
			max_point = Math.max(max_point, point);
		if (idx == N)
			return;

		Select(idx + 1, point + all[idx][0], cal + all[idx][1]); // 사용함
		Select(idx + 1, point, cal); // 사용안함

	}

}