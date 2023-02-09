import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;

		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) cnt++;
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					cnt++;
					break;
				}
			}
		}
		bw.write(T - cnt + " ");
		bw.flush();

	}

}