import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		int EOF = 0;
		int max = scanner.nextInt();
		int cnt = 0;
		int max_idx = 0;
		
		while(true){
		
			if(scanner.hasNext()){
				cnt++;
				int a = scanner.nextInt();
				if(max < a) {
					
					max = a;
					max_idx = cnt;
					
				}
			}
			else break;
			
		
		}
		
		System.out.println(max);
		System.out.println(max_idx+1);
		
		
		
	}
	
}