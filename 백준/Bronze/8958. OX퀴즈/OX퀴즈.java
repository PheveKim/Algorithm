import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		
		for(int i=0; i<N; i++) {
			
			String a = scanner.next();
			int point = 0;
			
			
			while(true) {
				int cnt = 0;
				while(a.substring(0,1).equals("O")) {
					
					cnt++;
					point += cnt;
					if(a.length() == 1) break;
					a = a.substring(1);
				}
				
				if(a.length() == 1) break;
				a = a.substring(1);
				
			}
			
			
			
			System.out.println(point);
			
		}
		
		
		
	}
	
}