import java.util.Scanner;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		
		System.out.println(A*(B%10));
		System.out.println((A*(B%100) - A*(B%10))/10);
		System.out.println((A*(B%1000) - A*(B%100))/100);
		System.out.println(A*B);
		
		
	}
	
}