import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {

			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int[][] arr = new int[N][N];

			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					arr[row][col] = scanner.nextInt();
				}
			}

			int max = 0;
			int sum = 0;
			int[] dx = new int[M];
			int[] dy = new int[M];

			for (int k = 0; k < M; k++) {
				dx[k] = k;
				dy[k] = k;
			}

			for (int row = 0; row < N - M + 1; row++) {
				for (int col = 0; col < N - M + 1; col++) {
					for (int k = 0; k < M; k++) {
						for (int p = 0; p < M; p++) {
							sum += arr[row + dx[k]][col + dy[p]];
						}
					}
					if (max < sum)
						max = sum;
					sum = 0;
				}
			}

			System.out.println("#" + (i + 1) + " " + max);
		}

	}

}