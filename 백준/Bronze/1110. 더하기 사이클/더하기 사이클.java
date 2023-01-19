import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		int M = scanner.nextInt();
		int cnt = 0;
		int N = M;
		
		while(true) {
			
			int N_right = N%10;
			int sum = N/10 + N%10;
			int sum_right = sum%10;
			
			int after = N_right * 10 + sum_right;
			
			cnt++;
			if (after == M) break;
			
			N = after;
		}
		
		System.out.println(cnt);
		
		
		
	}
	
}