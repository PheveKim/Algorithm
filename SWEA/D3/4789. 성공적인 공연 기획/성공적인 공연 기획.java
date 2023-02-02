import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			String input = br.readLine();
			int hit = 0;
			int more = 0;

			for (int j = 0; j < input.length(); j++) {
				
				if (hit >= j) 
					hit = hit +  Integer.parseInt(input.substring(j, j + 1));
				if (hit < j && Integer.parseInt(input.substring(j, j + 1)) != 0) {
					more = more + j - hit;
					hit = j + Integer.parseInt(input.substring(j, j + 1));
				}
			}
			System.out.println("#" + (i+1) + " " + more);

		}

		br.close();
		bw.close();

	}

}