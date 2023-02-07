import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int st1_length = st1.countTokens(); // countTokens() 함수를 for문 안에 넣으면 에러나더군요
												// 먼저 정의해주고 사용해주어야하는듯...~~~
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<st1_length; i++) {
				list.add(Integer.parseInt(st1.nextToken()));
			}
			
			Collections.sort(list);
			list.remove(0);
			list.remove(list.size()-1);
			double sum = 0;
			for(int i=0; i<list.size(); i++)
				sum += list.get(i);
			bw.write("#" + (t + 1) + " " + Math.round(sum/list.size()));
			bw.newLine();
			bw.flush();

		}

	}

}