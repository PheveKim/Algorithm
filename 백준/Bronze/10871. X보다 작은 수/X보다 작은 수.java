import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		
		for(int i=0; i<N; i++) {
			
			int a = scanner.nextInt();
			if(X > a) System.out.print(a + " ");
		}
		
		
		
		
		
	}
	
}