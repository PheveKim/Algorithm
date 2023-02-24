import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			
			ArrayList<Integer> list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);
			System.out.print("#" + (t+1) + " ");
			for(int i=0; i<N; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			
		}
	}
}