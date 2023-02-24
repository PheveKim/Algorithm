import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			int num = Integer.parseInt(str.substring(i,i+1));
			sum += num;
		}
		System.out.println(sum);
	}
}