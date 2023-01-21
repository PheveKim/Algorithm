
import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		String a = scanner.next();
		int sum = 0;
		
		for(int i=0; i<a.length(); i++) {
			
			char c = a.charAt(i);
			int each = c;
			sum += each-48;
			
		}
		
		System.out.println(sum);
		
		
		
		
		
	}
	
	
	
	
	
}
