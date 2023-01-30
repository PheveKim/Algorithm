import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		
		
		//int cost = A + B*N;
		//int profit = C*N;
		
		//A + B*N <= C*N
		//A / (C-B) <= N
		
		if(C-B <= 0) System.out.println(-1);
		else System.out.println(A/(C-B)+1);
		
		
	}
	
}