import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int st_len = st.countTokens();
		
		
		int sum = 0;
		for(int i=0; i<st_len; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num*num;
		}
		System.out.println(sum % 10);
		
		
	}
}