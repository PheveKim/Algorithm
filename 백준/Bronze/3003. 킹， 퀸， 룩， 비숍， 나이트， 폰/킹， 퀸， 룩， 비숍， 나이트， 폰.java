import java.util.Scanner;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] arr1 = {1,1,2,2,2,8};
		int[] arr2 = new int[6];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = scanner.nextInt();
			System.out.print(arr1[i]- arr2[i] + " ");
		}
		
	}
	
}