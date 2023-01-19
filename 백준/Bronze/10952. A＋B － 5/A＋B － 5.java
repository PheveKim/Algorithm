import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int EOF = 0;
		
		while(EOF != 1) {
			
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			if(a==0 && b==0) break;
			System.out.println(a+b);
			
			
		}
		
		
	}
	
}