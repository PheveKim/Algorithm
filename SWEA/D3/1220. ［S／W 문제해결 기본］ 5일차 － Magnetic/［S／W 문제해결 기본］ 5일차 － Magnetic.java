import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 0; t < 10; t++) {

			int S = Integer.parseInt(br.readLine());
			int[][] arr = new int[S][S];

			for (int i = 0; i < S; i++) {

				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				
				int stcnt = st.countTokens();
							
				for (int j = 0; j < stcnt; j++) {
					int A = Integer.parseInt(st.nextToken());
					arr[i][j] = A;
				}

			}
			
			int cnt = 0;
			int one_on = 0;

			for (int col = 0; col < S; col++) {
				for (int row = 0; row < S; row++) {
					if (arr[row][col] == 1)
						one_on = 1;
					else if (arr[row][col] == 2 && one_on == 1) {
						cnt++;
						one_on = 0;
					} 
				}
				one_on = 0;
			}

			bw.write("#" + (t+1) + " " + cnt);
			bw.newLine();
			bw.flush();
		}

	}

}