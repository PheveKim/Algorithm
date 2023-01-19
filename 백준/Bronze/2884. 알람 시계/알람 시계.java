import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int H = scanner.nextInt();
		int M = scanner.nextInt();
		
		
		if(M < 45) 
			if(H == 0) System.out.println(23 + " " + (M+15));
			else System.out.println(H-1 + " " + (M+15));
		else System.out.println(H + " " + (M-45));
		
		
		
		
		
		
	}
	
	
}