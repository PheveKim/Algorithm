import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int max = -1;
			for (int j = 0; j < N; j++) {
				for (int k = j+1; k < N; k++) {

					int mul = arr[j] * arr[k];
					String mul_str = Integer.toString(mul);
					int is_danjo = 1;
					int before = 0;
					for(int l=0; l<mul_str.length(); l++) {
						if (before > Integer.parseInt(mul_str.substring(l, l+1))){
							is_danjo = 0;
							break;
						}
						before = Integer.parseInt(mul_str.substring(l, l+1));
					}
					if(is_danjo == 1 && max < mul) max = mul;
				}
			}
			
			System.out.println("#" + (i+1) + " " + max);
			
		}

	}

}