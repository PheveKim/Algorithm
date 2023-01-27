import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String A = scanner.next();
		String B = scanner.next();
		String A_C = "";
		String B_C = "";
		
		for(int i=A.length()-1; i>=0; i--) {
			
			A_C += A.substring(i,i+1);
			B_C += B.substring(i,i+1);
			
		}
		
		if(Integer.parseInt(A_C) > Integer.parseInt(B_C)) System.out.println(A_C);
		else System.out.println(B_C);
		
		
		
	}

}