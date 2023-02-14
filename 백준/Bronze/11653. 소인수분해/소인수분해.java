import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int cnt = 2;

		while (true) {

			while (N % cnt == 0) {

				N = N / cnt;
				bw.write(cnt + "\n");
				bw.flush();

			}

			cnt++;
			if (N == 1)
				break;
		}
	}
}