import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		for (int i = 0; i < N; i++) {

			int n = scanner.nextInt();
			int[][] arr = new int[n][n];

			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					arr[row][col] = scanner.nextInt();
				}
			}

			String[] arr_90 = new String[n];
			String[] arr_180 = new String[n];
			String[] arr_270 = new String[n];

			String R = "";
			// 시계방향 90도 회전
			int R_cnt = 0;
			for (int col = 0; col < n; col++) {
				for (int row = n - 1; row >= 0; row--) {
					R += Integer.toString(arr[row][col]);
				}
				arr_90[R_cnt] = R;
				R = "";
				R_cnt++;
			}

			// 시계방향 180도 회전
			R_cnt = 0;
			for (int row = n - 1; row >= 0; row--) {
				for (int col = n - 1; col >= 0; col--) {
					R += Integer.toString(arr[row][col]);
				}
				arr_180[R_cnt] = R;
				R = "";
				R_cnt++;
			}

			// 시계방향 270도 회전
			R_cnt = 0;
			for (int col = n - 1; col >= 0; col--) {
				for (int row = 0; row < n; row++) {
					R += Integer.toString(arr[row][col]);
				}
				arr_270[R_cnt] = R;
				R = "";
				R_cnt++;
			}

			System.out.println("#" + (i + 1));
			for (int k = 0; k < n; k++) {
				System.out.println(arr_90[k] + " " + arr_180[k] + " " + arr_270[k]);
			}
		}

	}

}