import java.util.Scanner;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, Integer> codes = new HashMap<Integer, Integer>();
		
		int N = scanner.nextInt();
		int[] arr1 = new int[N];
		for(int i=0; i<N; i++) {
			codes.put(scanner.nextInt(), 1); 
		}
		

		int M = scanner.nextInt();
		int[] arr2 = new int[M];
		for(int i=0; i<M; i++) {
			arr2[i] = scanner.nextInt(); 
		}
		
		for(int i=0; i<arr2.length; i++) {
			int is_in = 0;
			try {
				if(codes.get(arr2[i]) == 1) is_in = 1;
			}
			catch (Exception e) {
			}
			
			System.out.println(is_in);
		}
		
		
	}
	
}