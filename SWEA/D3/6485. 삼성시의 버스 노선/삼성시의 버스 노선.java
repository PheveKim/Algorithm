import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		
		
		
		for(int i=0; i<T; i++) {
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			int N = scanner.nextInt();
			
			for(int j=0; j<N; j++) {
				
				int A = scanner.nextInt();
				int B = scanner.nextInt();
				
				for(int k=A; k<B+1; k++) {
					if(map.get(k) != null) map.put(k, map.get(k)+1);
					else map.put(k, 1);
				}
			}
			
			
			int P = scanner.nextInt();
			System.out.print("#" + (i+1) + " ");
			for(int j=0; j<P; j++) {
				int C = scanner.nextInt();
				if(map.get(C) != null) System.out.print(map.get(C) + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
		}
		
		
		
		

	}

}