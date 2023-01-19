import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int[] arrs = {a,b,c};
		
		if(a != b && a != c && b != c) System.out.println(max(arrs)*100);
		else if(a == b && a == c && b == c) System.out.println(a*1000 + 10000);
		else System.out.println(two_equal(arrs) * 100 + 1000);
		
		
		
	}
	
	public static int max(int[] arr) {
		
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) max = arr[i];
		}
		
		return max;
	}
	
	
	public static int two_equal(int[] arr) {
		
		int equal_num = 0;
		if(arr[0]==arr[1]) equal_num = arr[0];
		else if(arr[1]==arr[2]) equal_num = arr[1];
		else equal_num = arr[0];
		
		return equal_num;
	}
	
}