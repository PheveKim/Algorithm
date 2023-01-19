import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		
		int is_yun = 0;
		
		if(A%4==0 && A%100!=0) is_yun = 1;
		if(A%400==0) is_yun = 1;
		
		System.out.println(is_yun);
		
		
		
		
		
		
	}
	
	
}