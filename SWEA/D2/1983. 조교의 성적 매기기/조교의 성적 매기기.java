import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] grades = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());
			HashMap<Double, Integer> map = new HashMap<>();

			for (int i = 0; i < N; i++) {

				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				int mid_score = Integer.parseInt(st2.nextToken());
				int final_score = Integer.parseInt(st2.nextToken());
				int homework = Integer.parseInt(st2.nextToken());

				double total = mid_score * 0.35 + final_score * 0.45 + homework * 0.2;
				map.put(total, i + 1);

			}

			ArrayList<Double> list = new ArrayList<>(map.keySet());
			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				if (map.get(list.get(i)) == K) {
					bw.write("#" + (t + 1) + " " + grades[(list.size() - i - 1) / (N / 10)]);
					break;
				}
			}
			bw.newLine();
			bw.flush();

		}

	}

}