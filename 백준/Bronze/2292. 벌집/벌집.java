import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int cnt = 0;
		if(N == 1) System.out.println(1);
		else {
			while(true) {
				
				if(3*Math.pow(cnt+1,2) + 3*(cnt+1) + 2 > N) {
					System.out.println(cnt+2);
					break;
				}
				cnt++;
				
			}
		}
		
		
		
	}
	
}