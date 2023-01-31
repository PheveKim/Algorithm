import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int m = 0;
		int n = 0;
		int answer = 10000;
		while(N - 3*m >= 0) {
			if((N-3*m) % 5 == 0) {
				n = (N-3*m) / 5;
				if(answer > m+n) answer = m+n;
			}
			m++;
		}
		
		if(answer == 10000) System.out.println(-1);
		else System.out.println(answer);
		
		
	}
	
}