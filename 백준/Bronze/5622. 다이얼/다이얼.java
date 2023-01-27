import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		String alphabet = "ABCDEFGHIJKLMNOPQRTUVWXY";
		
		String input = scanner.next();
		
		int num = 0;
		int num_before = 0;
		int dist_sum = 0;
		for(int i=0; i<input.length(); i++) {
			
			for(int j=0; j<alphabet.length(); j++) {
				if(input.substring(i, i+1).equals("Z")) {
					num = 9;
					break;
				}
				if(input.substring(i, i+1).equals("S")) {
					num = 7;
					break;
				}
				if(alphabet.substring(j, j+1).equals(input.substring(i, i+1))) {
					num = j/3 + 2;
					break;
				}
			}
			dist_sum += Math.abs(num_before - num) + 1;
		}
		
		System.out.println(dist_sum);
	}

}