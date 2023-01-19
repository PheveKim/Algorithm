import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		int T = scanner.nextInt();
		int EOF = 0;
		
		while(EOF != 1) {
			try {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				System.out.println(a+b);
			}
			
			catch (Exception e) {
				EOF = 1;
			}
			
			
			
		}
		
	}
	
}