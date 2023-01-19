import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int a1 = scanner.nextInt();
		
		int max = a1;
		int min = a1;
		
		
		for(int i=1; i<N; i++) {
			
			int b = scanner.nextInt();
			
			if( max < b) max = b;
			if( min > b) min = b;
			
			
		}
		System.out.print(min + " " + max);
		
		
		
		
		
	}
	
}