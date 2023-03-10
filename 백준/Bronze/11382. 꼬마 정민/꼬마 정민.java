import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
//		st = new StringTokenizer(br.readLine(), " ");
//		int N = Integer.parseInt(br.readLine());
//		int st_len = st.countTokens();
//		String input = br.readLine();
//		for(int i=0; i<N; i++) {
//			System.out.println(i+1);
//		}

		st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
		System.out.print(A + B + C);
	   
	}
}