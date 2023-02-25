import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		int[] insu = {2,3,5,7,11};
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine().trim());
			int num_copy;
			int cnt;
			
			System.out.print("#" + (t+1) + " ");
			for(int i=0; i<insu.length; i++) {
				num_copy = num;
				cnt = 0;
				while(true) {
					if(num_copy % insu[i] == 0) {
						cnt++;
						num_copy /= insu[i];
					} else {
						break;
					}
				}
				System.out.print(cnt + " ");
			}
			System.out.println();
			
			
		}
	}
}