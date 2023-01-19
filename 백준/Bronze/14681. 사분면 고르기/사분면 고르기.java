import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int X = scanner.nextInt();
		int Y = scanner.nextInt();
		
		
		if(X>0 && Y>0) System.out.println(1);
		if(X>0 && Y<0) System.out.println(4);
		if(X<0 && Y>0) System.out.println(2);
		if(X<0 && Y<0) System.out.println(3);
		
		
		
		
		
	}
	
	
}