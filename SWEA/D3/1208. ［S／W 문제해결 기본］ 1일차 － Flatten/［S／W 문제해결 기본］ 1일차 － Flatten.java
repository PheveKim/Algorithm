import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < 10; t++) {

			int dump = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");
			int st_len = st.countTokens();

			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 0; i < st_len; i++) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}

			Collections.sort(list);
			int cnt = 0;

			while (true) {

				int last_idx = list.size() - 1;
				int first_idx = 0;

				list.set(last_idx, list.get(last_idx) - 1);
				list.set(first_idx, list.get(first_idx) + 1);

				Collections.sort(list);

				cnt++;
				if (cnt >= dump)
					break;

			}

			int diff = 0;
			diff = list.get(list.size() - 1) - list.get(0);

			bw.write("#" + (t + 1) + " " + diff + "\n");
			bw.flush();
		}

	}

}