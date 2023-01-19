import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int H = scanner.nextInt();
		int M = scanner.nextInt();
		int Duration = scanner.nextInt();
		
		int Duration_H = Duration / 60;
		int Duration_M = Duration % 60;
		
		int answer_H = H + Duration_H;
		int answer_M = M + Duration_M;
		
		if(answer_M >= 60) {
			answer_M = answer_M - 60;
			answer_H = answer_H + 1;
		}
		
		if(answer_H >= 24) {
			answer_H = answer_H - 24;
		}
		
		System.out.println(answer_H + " " + answer_M);
		
		
		
	}
	
	
}