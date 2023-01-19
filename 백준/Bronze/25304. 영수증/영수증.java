import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int X = scanner.nextInt();
		int N = scanner.nextInt();
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			
			sum += A*B;
			
			
		}
		
		if(X == sum) System.out.println("Yes");
		else System.out.println("No");
		
		
		
	}
	
}