import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		
		
		for(int i=1; i<N+1; i++) {
			String num = Integer.toString(i);
			String result = "";
			int cnt = 0;
			for(int j=0; j<num.length(); j++) {
				int digit = Integer.parseInt(num.substring(j,j+1));
				if(digit==3 || digit==6 || digit==9) {
					if(cnt == 0) {
						result = "-";
						cnt++;
					}
					else if(cnt >= 1) {
						result += "-";
						cnt++;
					}
				}
				
				else {
					if(cnt == 0) result += Integer.toString(digit);
				}
			}
			System.out.print(result + " ");
		}
		
	}
}