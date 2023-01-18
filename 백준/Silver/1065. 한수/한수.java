import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int cnt = 0;
		
		
		
		for(int i=1; i<N+1; i++) {
			if(i<100) {
				cnt++;
			}
			else {
				Stack<Integer> stack = new Stack<>();
				int num = i;
				int is_han = 1;
				
				int digit_1 = num % 10;
				int digit_2 = (num / 10)%10;
				int d = digit_2 - digit_1;
				stack.push(digit_1);
				num = num / 10;
				
				while(num != 0) {
					
					int digit = num % 10;
					
					if((digit - stack.peek()) != d) {
						is_han = 0;
						break;
					}
					
				    stack.push(digit);
					
					num = num / 10;
					
				}
				if(is_han == 1) cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
		
		
	}
	
}