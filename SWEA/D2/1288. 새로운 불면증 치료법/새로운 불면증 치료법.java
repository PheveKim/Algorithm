import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());

			HashMap<String, Integer> map = new HashMap<>();
			int num = N;
			int k = 1;
			while (true) {

				
				String str = Integer.toString(num);
				for (int i = 0; i < str.length(); i++) {
					map.put(str.substring(i, i + 1), 1);
				}

				if (map.size() == 10)
					break;
				k++;
				num = N * k;
			}

			bw.write("#" + (t + 1) + " " + num + "\n");
			bw.flush();
		}

	}

}