import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		String A = scanner.next();
		String B = scanner.next();
		String target = "";
		String non_target = "";
		
		if(A.length() > B.length()) {
			target = B;
			non_target = A;
		}
		else {
			target = A;
			non_target = B;
		}
		
		int diff = non_target.length()-target.length();
		int sum = 0;
		int carry = 0;
		String all = "";
		
		for(int i=target.length()-1; i>=0; i--) {
			
			
			sum = Integer.parseInt(target.substring(i, i+1)) + 
				  Integer.parseInt(non_target.substring(i+diff, i+diff+1)) +
				  carry;
			
			carry = sum/10;
			sum = sum%10;
			
			all = Integer.toString(sum) + all;
			
		}
		
		for(int i=diff-1; i>=0; i--) {
			
			sum = Integer.parseInt(non_target.substring(i, i+1)) +
				  carry;
			
			carry = sum/10;
			sum = sum%10;
			
			all = Integer.toString(sum) + all;
		}
		
		
		if(carry != 0) all = Integer.toString(carry) + all;
		System.out.println(all);
		
		
		
		
	}
	
}