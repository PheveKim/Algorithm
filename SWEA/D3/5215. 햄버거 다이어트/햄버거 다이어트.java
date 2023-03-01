import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int N;
	static int C;
	static int max;
	static int o;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = 0;
			int[] tastes = new int[N];
			int[] cals = new int[N];
			boolean[] visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				tastes[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			}

			choose(tastes, cals, visited, 0, 0, 0);

			bw.write("#" + (t + 1) + " " + max);
			bw.newLine();
			bw.flush();
		}

	}

	public static void choose(int[] tastes, int[] cals, boolean[] visited, int cal_sum, int taste_sum, int last_idx) {
		for (int i = last_idx; i < N; i++) {
			if (visited[i] == false && cal_sum + cals[i] <= C) {
				max = Math.max(max, taste_sum + tastes[i]);
				visited[i] = true;
//				System.out.println(i + " " + (taste_sum + tastes[i]) + " " + (cal_sum + cals[i]) + "  " + Arrays.toString(visited));
				choose(tastes, cals, visited, cal_sum + cals[i], taste_sum + tastes[i], i);
				visited[i] = false;
			}
		}
	}
}