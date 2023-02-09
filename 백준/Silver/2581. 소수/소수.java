import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		boolean sosu = true;
		
		Loop1 : for(int i=b; i>=a; i--) {
			sosu = true;
			if(i==1) sosu = false;
			for(int j=2; j<i; j++)
				if(i % j == 0) {
					sosu = false;
					break;
				}
			if(sosu) {
				sum += i;
				min = i;
				
			}
			
			
		}
		
		if(min==0) System.out.println(-1);
		else System.out.println(sum + "\n" + min);

	}

}