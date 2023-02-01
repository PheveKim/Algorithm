import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		
		
		for(int i=0; i<T; i++) {
			String answer = "Possible";
			
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int K = scanner.nextInt();
			
			
			int[] come = new int[N];
			for(int j=0; j<N; j++) {
				come[j] = scanner.nextInt();
			}
			
			int max = 0;
			for(int j=0; j<come.length; j++) {
				if(max < come[j]) max = come[j];
			}
			
			int[] make = new int[max+1];
			int[] eat = new int[max+1];
			
			for(int j=0; j<come.length; j++) {
				eat[come[j]] = -1;
			}
			
			for(int j=1; j<make.length; j++) {
				if(j%M == 0) make[j] = K;
			}
			
			
			int sum = 0;
			for(int j=0; j<make.length; j++) {
				sum += make[j] + eat[j];
				if(sum < 0) answer = "Impossible";
			}
			
			
			
			
			
			
			System.out.println("#" + (i+1) + " " + answer);
		}
		

	}

}