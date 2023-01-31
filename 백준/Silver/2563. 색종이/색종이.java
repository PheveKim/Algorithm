import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int all[][] = new int[100][100];
		int N = scanner.nextInt();
		
		for(int i=0; i<N; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			for(int row=x; row<x+10; row++) {
				for(int col=y; col<y+10; col++) {
					all[row][col] = 1;
				}
			}
		}
		
		int sum = 0;
		for(int row=0; row<100; row++) {
			for(int col=0; col<100; col++) {
				sum += all[row][col];
			}
		}
		
		System.out.println(sum);
		
	}
	
}