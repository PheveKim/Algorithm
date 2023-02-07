import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int input = Integer.parseInt(br.readLine());
			int sum_1 = 0;
			for(int i=1; i<input+1; i++)
				sum_1 += i;
			
			int sum_2 = 0;
			for(int i=1; i<input/2 + 1; i++)
				sum_2 += i*2;
			
			bw.write("#" + (t + 1) + " " + (sum_1 - 2*sum_2));
			bw.newLine();
			bw.flush();

		}

	}

}