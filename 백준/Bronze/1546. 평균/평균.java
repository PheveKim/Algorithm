import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int max = scanner.nextInt();
		int[] all = new int[N];
		all[0] = max;
		for(int i=1; i<N; i++) {
			
			int a = scanner.nextInt();
			if(max < a) max = a;
			all[i] = a;
			
		}
		
		double sum = 0;
		double max_double = max;
		for(int i=0; i<N; i++) {
			sum += all[i]/max_double*100;
		}
		System.out.println(sum/N);
		
	}
	
}