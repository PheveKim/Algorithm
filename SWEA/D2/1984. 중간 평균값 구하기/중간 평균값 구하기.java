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

			st = new StringTokenizer(br.readLine());
			int max = 0;
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < 10; i++)
				list.add(Integer.parseInt(st.nextToken()));
			
			double sum = 0;
			Collections.sort(list);
			for(int i=1; i<list.size()-1; i++) {
				sum += list.get(i);
			}
			
			
			bw.write("#" + (t + 1) + " " + Math.round(sum/(list.size()-2)));
			bw.newLine();
			bw.flush();

		}

	}

}