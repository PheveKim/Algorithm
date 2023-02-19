import java.util.*;

import javax.imageio.IIOException;

import java.io.*;
import java.lang.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int all[][] = new int[102][102];
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> xs = new ArrayList<>();
		ArrayList<Integer> ys = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			xs.add(x);
			ys.add(y);

		}

		for (int i = 0; i < N; i++) {
			int x = xs.get(i) + 1;
			int y = ys.get(i) + 1;

			for (int row = x; row < x + 10; row++) {
				for (int col = y; col < y + 10; col++) {
					all[row][col] = 1;
				}
			}
		}

		int cnt = 0;
		for (int row = 0; row < 102; row++) {
			for (int col = 0; col < 102; col++) {
				if (all[row][col] == 1) {
					for (int i = 0; i < 4; i++) {
						int nr = row + dr[i];
						int nc = col + dc[i];

						if (all[nr][nc] == 0) {
							cnt++;
						}
					}

				}
			}
		}

		System.out.println(cnt);
	}

}