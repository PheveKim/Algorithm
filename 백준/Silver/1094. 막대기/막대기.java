import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int X = scanner.nextInt();
		int now = 64;
		int sum = 0;
		int now_half = 0;
		int cnt = 0;
		
		while(sum < X) {
			
			if(X == 64) break;
			
			now_half = now / 2;
			if(sum + now_half == X) {
				sum = sum + now_half;
				now = now_half;
				break;
			}
			
			if(sum + now_half < X) {
				sum = sum + now_half;
				now = now_half;
				cnt++;
			}
			
			else {
				now = now_half;
			}
			
			if(sum == X-1) sum = X;
			
			
		}
		System.out.println(cnt+1);
		
		
		
	}
	
}