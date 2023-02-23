import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min;
	static int max_connected_cnt;
	static int N;
	static int core_cnt;
	static int o = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			ArrayList<Integer> rs = new ArrayList<>();
			ArrayList<Integer> cs = new ArrayList<>();
			core_cnt = 0;
			min = Integer.MAX_VALUE;
			max_connected_cnt = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			int done_cnt = 0;
			int connected_cnt = 0;
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
					if (arr[row][col] == 1) {
						core_cnt++;
						if (row == 0 || row == N - 1 || col == 0 || col == N - 1) {
							done_cnt++;
							connected_cnt++;
						} else {
							rs.add(row);
							cs.add(col);
						}
					}
				}
			}

			search(arr, done_cnt, connected_cnt, rs, cs);
			System.out.println("#" + (t + 1) + " " + min);
		}

	}

	public static void search(int[][] input_arr, int done_cnt, int connected_cnt, ArrayList<Integer> rs,
			ArrayList<Integer> cs) {

		if (connected_cnt + core_cnt - done_cnt >= max_connected_cnt) {
			if (done_cnt >= core_cnt) {
				o++;
				int line_cnt = 0;
				for (int row = 0; row < N; row++) {
					for (int col = 0; col < N; col++) {
						if (input_arr[row][col] == 3)
							line_cnt++;
					}
				}
				if (max_connected_cnt < connected_cnt) {
					max_connected_cnt = connected_cnt;
					min = line_cnt;
				} else if (max_connected_cnt == connected_cnt) {
					min = Math.min(min, line_cnt);
				}
			}

			else {
				for (int c = 0; c < rs.size(); c++) {
					int row = rs.get(c);
					int col = cs.get(c);

					boolean changed = false;

					Loop1: for (int i = 0; i < 4; i++) {
						int k = 1;
						while (true) {
							int nr = row + dr[i] * k;
							int nc = col + dc[i] * k;

							if (nr < 0 || nr >= N || nc < 0 || nc >= N) {

								int[][] input_arr_copy = new int[N][N];
								for (int r = 0; r < N; r++) {
									input_arr_copy[r] = Arrays.copyOf(input_arr[r], N);
								}

								ArrayList<Integer> rs_copy = new ArrayList<>();
								ArrayList<Integer> cs_copy = new ArrayList<>();
								for (int l = 0; l < rs.size(); l++) {
									if (l == c) {
										continue;
									}
									rs_copy.add(rs.get(l));
								}
								for (int l = 0; l < cs.size(); l++) {
									if (l == c) {
										continue;
									}
									cs_copy.add(cs.get(l));
								}

								for (int p = 1; p < k; p++) {
									input_arr_copy[row + dr[i] * p][col + dc[i] * p] = 3;
								}

								search(input_arr_copy, done_cnt + 1, connected_cnt + 1, rs_copy, cs_copy);
								changed = true;
								if (k == 1)
									break Loop1;
								break;
							}

							else if (input_arr[nr][nc] == 0) {
								k++;
							} else {
								break;
							}

						}
					}
					if (changed == false) {
						ArrayList<Integer> rs_copy = new ArrayList<>();
						ArrayList<Integer> cs_copy = new ArrayList<>();
						for (int l = 0; l < rs.size(); l++) {
							if (l == c) {
								continue;
							}
							rs_copy.add(rs.get(l));
						}
						for (int l = 0; l < cs.size(); l++) {
							if (l == c) {
								continue;
							}
							cs_copy.add(cs.get(l));
						}
						search(input_arr, done_cnt + 1, connected_cnt, rs_copy, cs_copy);
					}
					break;
				}

			}

		}

	}

}