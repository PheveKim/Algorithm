import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");

			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

			for (int q = 1; q <= Q; q++) {

				String str2 = br.readLine();
				StringTokenizer st2 = new StringTokenizer(str2, " ");
				int L = Integer.parseInt(st2.nextToken());
				int R = Integer.parseInt(st2.nextToken());

				for (int idx = L - 1; idx < R; idx++)
					arr[idx] = q;
			}

			bw.write("#" + (t + 1) + " ");
			for (int idx = 0; idx < arr.length; idx++)
				bw.write(arr[idx] + " ");
			bw.newLine();
			bw.flush();

		}

	}

}