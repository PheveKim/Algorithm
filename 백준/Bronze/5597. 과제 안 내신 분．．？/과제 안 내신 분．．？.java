import java.io.EOFException;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[30];
		
		
		for(int i=0; i<28; i++) {
			int s = scanner.nextInt();
			arr[s-1] = 1;
		}
		
		for(int i=0; i<30; i++) {
			if(arr[i]==0) System.out.println(i+1);
		}
		
	}
}