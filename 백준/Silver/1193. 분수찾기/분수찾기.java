import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		int n = 1;
		
		while(true) {
			if(input <= n*(n+1)/2) break;
			n++;
		}
		if((n+1)%2 == 0) System.out.printf("%d/%d", n*(n+1) / 2 - input + 1, n-n*(n+1)/2+input);
		else System.out.printf("%d/%d", n-n*(n+1)/2+input, n*(n+1) / 2 - input + 1);
		
		
	}
	
}