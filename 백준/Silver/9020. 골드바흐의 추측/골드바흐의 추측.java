import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int num = Integer.parseInt(br.readLine());

			int half = num / 2;

			for (int i = half; i < num; i++) {

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
					cnt = 2;
					cnt2 = 0;
					while (true) {

						if (cnt > sqrt)
							break;
						if ((num-i) % cnt == 0) {
							cnt2++;
							break;
						}

						cnt++;
						if (cnt >= num-i)
							break;
					}
					if(cnt2 == 0) {
						bw.write((num-i) + " " + i + "\n");
						bw.flush();
						break;
					}
				}

			}

		}

	}

}