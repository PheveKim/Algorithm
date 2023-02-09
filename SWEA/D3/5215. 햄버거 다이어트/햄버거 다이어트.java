import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			ArrayList<String>[] arr = new ArrayList[N];

			for (int n = 0; n < N; n++) {
				arr[n] = new ArrayList<>();
				arr[n].add(br.readLine());
			}

			int max_point = 0;
			for (int n = 1; n < N; n++) {

				for (int i = 0; i < n; i++) {

					for (int j = 0; j < arr[i].size(); j++) {

						st = new StringTokenizer(arr[i].get(j), " ");
						int point = Integer.parseInt(st.nextToken());
						int calorie = Integer.parseInt(st.nextToken());

						st = new StringTokenizer(arr[n].get(0), " ");
						int cur_point = Integer.parseInt(st.nextToken());
						int cur_calorie = Integer.parseInt(st.nextToken());

						if (calorie + cur_calorie <= L) {
							arr[n].add((point + cur_point) + " " + (calorie + cur_calorie));
							max_point = Math.max(max_point, point + cur_point);
						}

					}

				}

			}
			

			bw.write("#" + (t + 1) + " " + max_point);
			bw.newLine();
			bw.flush();

		}

	}

}