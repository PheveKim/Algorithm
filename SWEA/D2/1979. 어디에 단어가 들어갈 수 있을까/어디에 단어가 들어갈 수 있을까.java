import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		for(int i=0; i<N; i++) {
			
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			
			int arr[][] = new int[n][n];
			
			for(int row=0; row<n; row++) {
				for(int col=0; col<n; col++) {		
					arr[row][col] = scanner.nextInt();
				}
			}
			
			int cnt = 0;
			for(int row=0; row<n; row++) {
				for(int col=0; col<n-k+1; col++) {
					
					int mul = 1;
					for(int t=0; t<k; t++) {
						
						mul *= arr[row][col+t];
					}
					
					if(mul == 1) {
						int side_left = 1;
						int side_right = 1;
						
						try {
							if(arr[row][col-1] == 0) side_left = 0;
						}
						catch(Exception e) {
							side_left = 0;
						}
						try {
							if(arr[row][col+k] == 0) side_right = 0;
						}
						catch(Exception e) {
							side_right = 0;
						}
						
						if(side_left == 0 && side_right == 0) {
							cnt++;
						}
						
					}
					
				}
			}
			
			for(int col=0; col<n; col++) {
				for(int row=0; row<n-k+1; row++) {
					
					int mul = 1;
					for(int t=0; t<k; t++) {
						
						mul *= arr[row+t][col];
					}
					
					if(mul == 1) {
						int side_left = 1;
						int side_right = 1;
						
						try {
							if(arr[row-1][col] == 0) side_left = 0;
						}
						catch(Exception e) {
							side_left = 0;
						}
						try {
							if(arr[row+k][col] == 0) side_right = 0;
						}
						catch(Exception e) {
							side_right = 0;
						}
						
						if(side_left == 0 && side_right == 0) {
							cnt++;
						}
						
					}
					
				}
			}
			
			System.out.println("#" + (i+1) + " " + cnt);
			
		}
		
		
	}
	
}