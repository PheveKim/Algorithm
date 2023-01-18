import java.util.Scanner;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		
		HashMap<Integer, Integer> codes = new HashMap<Integer, Integer>();
		
		
		for(int i=1; i<10001; i++) {
			codes.put(i, 1);
		}
		
		
		for(int i=1; i<10001; i++) {
			
			int sum = i;
			int num = i;
			
			while(num != 0) {
				
				sum += num % 10;
				num = num / 10;
				
			}
			codes.put(sum, 0);
		}
		
		for(int key : codes.keySet()) {
			if(codes.get(key) == 1) System.out.println(key);
		}
		
		
		
	}
	
}