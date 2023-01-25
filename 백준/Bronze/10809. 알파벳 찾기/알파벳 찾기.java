import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String S = scanner.next();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<alphabet.length(); i++) {
			int is_in = 0;
			for(int j=0; j<S.length(); j++) {
				
				if(alphabet.substring(i,i+1).equals(S.substring(j,j+1))) {
					System.out.print(j + " ");
					is_in = 1;
					break;
				}
			}
			if(is_in != 1) System.out.print(-1 + " ");
			
		}
		
		
	}
	
}