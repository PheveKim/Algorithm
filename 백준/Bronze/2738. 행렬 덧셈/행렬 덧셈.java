import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int R = scanner.nextInt();
		int C = scanner.nextInt();
		
		int[][] arr1 = new int[R][C];
		int[][] arr2 = new int[R][C];
		
		for(int row=0; row<R; row++) {
			for(int col=0; col<C; col++) {
				arr1[row][col] = scanner.nextInt();
			}
		}
		
		for(int row=0; row<R; row++) {
			for(int col=0; col<C; col++) {
				arr2[row][col] = scanner.nextInt();
			}
		}
		
		for(int row=0; row<R; row++) {
			for(int col=0; col<C; col++) {
				int answer = arr1[row][col] + arr2[row][col];
				System.out.print(answer + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
}