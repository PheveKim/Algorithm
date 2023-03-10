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
		String input = br.readLine();
//		for(int i=0; i<N; i++) {
//			System.out.println(i+1);
//		}
		
		
		String a = "abcdefghijklmnopqrstuvwxyz";
		String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String str = "";
		for(int i=0; i<input.length(); i++) {
			for(int j=0; j<a.length(); j++) {
				if(input.substring(i,i+1).equals(a.substring(j,j+1))) {
					str += A.substring(j,j+1);
				}
				else if(input.substring(i,i+1).equals(A.substring(j,j+1))) {
					str += a.substring(j,j+1);
				}
			}
			
		}
		System.out.println(str);
		
	}
}