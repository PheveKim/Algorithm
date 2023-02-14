import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {

			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int cnt_sosu = 0;

			for (int i = n + 1; i <= 2 * n; i++) {

				int cnt = 2;
				int cnt2 = 0;
				if (i == 1)
					continue;
				double sqrt = Math.sqrt(i);
				while (true) {

					if (cnt > sqrt)
						break;
					if (i % cnt == 0) {
						cnt2++;
						break;
					}

					cnt++;
					if (cnt >= i)
						break;
				}
				if (cnt2 == 0) {
					cnt_sosu++;
				}

			}
			bw.write(cnt_sosu + "\n");
			bw.flush();
		}

	}

}