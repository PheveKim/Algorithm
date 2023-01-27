import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		
		for(String key : map.keySet()) {
			System.out.println(key + "" + map.get(key));
		}
		
		for(int i=0; i<input.length(); i++) {
			
			String letter = input.substring(i,i+1).toLowerCase();
			
			if(map.get(letter) == null) {
				map.put(letter, 1);
			}
			else {
				map.put(letter, map.get(letter) + 1);
			}
			
		}
		
		int max = 0;
		String target = "";
		for(String key : map.keySet()) {
			if(max < map.get(key)) {
				target = key;
				max = map.get(key);
			}
		}
		map.remove(target);
		int max_2 = 0;
		String target_2 = "";
		for(String key : map.keySet()) {
			if(max_2 < map.get(key)) {
				target_2 = key;
				max_2 = map.get(key);
			}
		}
		
		if(max == max_2) System.out.println("?");
		else System.out.println(target.toUpperCase());
		
		
		
		
		
	}
	
}