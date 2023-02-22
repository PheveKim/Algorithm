import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static int W;
	static int H;
	static int B;
	static int min;
	static int o;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine(), " ");
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];

			for (int row = 0; row < H; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int col = 0; col < W; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			o = 0;
			int[] test3 = new int[B];
			min = Integer.MAX_VALUE;
			drop(arr, 0, test3);

			System.out.println("#" + (t + 1) + " " + min);
		}

	}

	public static void drop(int[][] new_arr, int cnt, int[] test3) {
		cnt++;

		if (cnt > B) {
			o++;
			int[][] new_arr_copy = new int[H][W];
			for (int row = 0; row < H; row++) {
				new_arr_copy[row] = Arrays.copyOf(new_arr[row], W);
			}

			for (int p = 0; p < test3.length; p++) {
				for (int row = 0; row < H; row++) {
					if (new_arr_copy[row][test3[p]] != 0) {
						explode(new_arr_copy, row, test3[p]);
						move_down(new_arr_copy);
						break;
					}
				}
			}

			int sum = 0;
			for (int row = 0; row < H; row++) {
				for (int col = 0; col < W; col++) {
					if (new_arr_copy[row][col] != 0) {
						sum++;
					}
				}
			}
			min = Math.min(min, sum);
		}

		else {
			for (int col = 0; col < W; col++) {
				test3[cnt - 1] = col;
				drop(new_arr, cnt, test3);
			}
		}

	}

	public static void explode(int[][] new_arr, int row, int col) {

		int amount = new_arr[row][col] - 1;
		new_arr[row][col] = 0;

		for (int i = 0; i < 4; i++) {
			int k = 1;

			while (true) {
				if (k > amount)
					break;
				int nr = row + dr[i] * k;
				int nc = col + dc[i] * k;

				if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
					if (new_arr[nr][nc] != 0) {
						explode(new_arr, nr, nc);
					}
				}

				k++;
			}

		}

	}

	public static void move_down(int[][] new_arr) {

		int H = new_arr.length;
		int W = new_arr[0].length;

		for (int col = 0; col < W; col++) {
			for (int row = H - 1; row >= 1; row--) {
				if (new_arr[row][col] == 0) {
					for (int i = row - 1; i >= 0; i--) {
						if (new_arr[i][col] != 0) {
							new_arr[row][col] = new_arr[i][col];
							new_arr[i][col] = 0;
							break;
						}
					}
				}
			}

		}

	}

}