import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int C = scanner.nextInt();
		
		
		for(int i=0; i<C; i++) {
			
			int N = scanner.nextInt();
			int[] arr = new int[N];
			double sum = 0;
			
			for(int j=0; j<N; j++) {
				
				int a = scanner.nextInt();
				arr[j] = a;
				sum += a;
				
			}
			
			double avg = sum / N;  
			double cnt = 0;
			for(int j=0; j<arr.length; j++) {
				if(arr[j] > avg) cnt++;
			}
			// System.out.println(Math.round(cnt/N*100*1000)/1000.0);
			// Math.round() 는 소수점 아래가 0일 경우 절삭.
			// String.format 은 절삭하지 않음.
			
			System.out.println(String.format("%.3f", cnt/N*100) + "%");
			
			
		}
		
		
	}
	
}