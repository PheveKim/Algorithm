import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		int N = scanner.nextInt();
		
		for(int i=0; i<N; i++) {
			
			
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			
			int arr[][] = new int[15][14];
			for(int j=0; j<14; j++) {
				arr[0][j] = j+1;
			}
			
			for(int row=1; row<15; row++) {
				arr[row][0] = 1;
				for(int col=1; col<14; col++) {
					arr[row][col] = arr[row][col-1] + arr[row-1][col];
				}
			}
			
			
			System.out.println(arr[k][n-1]);
			
			
		}
		
		
		
		
	}
	
}