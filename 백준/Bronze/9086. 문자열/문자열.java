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
//	       _.-;;-._
//	       '-..-'|   ||   |
//	       '-..-'|_.-;;-._|
//	       '-..-'|   ||   |
//	       '-..-'|_.-''-._|
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			System.out.print(str.substring(0,1));
			System.out.println(str.substring(str.length()-1,str.length()));
			
		}
	   
	}
}