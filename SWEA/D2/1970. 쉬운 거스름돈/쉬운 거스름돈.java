import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int num = Integer.parseInt(br.readLine());

			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			int f = 0;
			int g = 0;
			int h = 0;

			a = num / 50000;
			num %= 50000;
			b = num / 10000;
			num %= 10000;
			c = num / 5000;
			num %= 5000;
			d = num / 1000;
			num %= 1000;
			e = num / 500;
			num %= 500;
			f = num / 100;
			num %= 100;
			g = num / 50;
			num %= 50;
			h = num / 10;
			num %= 10;

			System.out.println(
					"#" + (t + 1) + "\n" + a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h);
		}
	}

}