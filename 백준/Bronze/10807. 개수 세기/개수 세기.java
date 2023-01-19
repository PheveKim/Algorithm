import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int[] arr = new int[N];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			
			arr[i] = scanner.nextInt();
			
		
		}
		
		int v = scanner.nextInt();
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] == v) cnt++;
			
		}
		System.out.println(cnt);
		
		
		
		
		
	}
	
}