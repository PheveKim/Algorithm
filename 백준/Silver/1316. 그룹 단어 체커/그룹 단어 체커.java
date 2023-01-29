import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			
			String input = scanner.next();
			String target_before = "";
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int j=0; j<input.length(); j++){
				
				String target = input.substring(j,j+1);
				if(map.get(target) != null && map.get(target) == 1 && !target.equals(target_before)) {
					cnt++;
					break;
				}
				map.put(target, 1);
				target_before = target;
			}
			
		}
		
		System.out.println(N - cnt);
		
		
		
		
		
		
	}
	
}