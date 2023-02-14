import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		for (int i = A; i <= B; i++) {

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
				bw.write(i + "\n");
				bw.flush();
			}

		}

	}

}