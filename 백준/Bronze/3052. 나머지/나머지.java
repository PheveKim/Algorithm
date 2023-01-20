import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[42];
		for(int i=0; i<10; i++) {
			
			int a = scanner.nextInt();
			arr[a%42] = 1;
			
		}
		
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] != 0) cnt++;
			
		}
		System.out.println(cnt);
		
		
		
	}
	
}