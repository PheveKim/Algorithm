import java.util.*;

import javax.imageio.IIOException;

import java.io.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());

			if (s == 1) {
				int cnt = 1;
				while (true) {

					if (cnt * idx >= N + 1)
						break;

					if (arr[cnt * idx] == 1)
						arr[cnt * idx] = 0;
					else
						arr[cnt * idx] = 1;

					cnt++;

				}
			}

			else if (s == 2) {
				int cnt = 1;
				while (true) {

					if (idx - cnt < 1 || idx + cnt >= N + 1)
						break;

					if (arr[idx - cnt] == arr[idx + cnt]) {
						cnt++;
					} else
						break;

				}

				for (int k = idx - cnt + 1; k < idx + cnt; k++) {
					if (arr[k] == 1)
						arr[k] = 0;
					else
						arr[k] = 1;
				}
			}

		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	}

}