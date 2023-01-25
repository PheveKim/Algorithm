import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int i=0; i<T; i++) {
			int R = scanner.nextInt();
			String S = scanner.next();
			String last = "";
			for(int j=0; j<S.length(); j++) {
				
				for(int k=0; k<R; k++) {
					
					last += S.substring(j,j+1);
					
				}
				
			}
			System.out.println(last);
			
		}
		
		
	}
	
}