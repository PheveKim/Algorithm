import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			int tc = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");
			int st_len = st.countTokens();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < st_len; i++) {
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}
			Collections.sort(list);

			int num;
			int before = 101;
			int max_cnt = 0;
			int max_num = 0;
			int cnt = 1;
			for (int i = 0; i < list.size(); i++) {
				num = list.get(i);
				if (before == num) {
					cnt++;
				} else {
					if (max_cnt == cnt) {
						max_num = Math.max(max_num, before);
					} else if (max_cnt < cnt) {
						max_cnt = cnt;
						max_num = before;
					}
					cnt = 1;
				}
				before = num;
			}
			System.out.println("#" + (t+1) + " " + max_num);
		}
	}
}