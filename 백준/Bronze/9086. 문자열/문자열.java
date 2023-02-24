import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<T; i++) {
			String[] str = sc.nextLine().split("");
			if(str.length>1) {
				System.out.println(str[0]+str[str.length-1]);
			}else {
				System.out.println(str[0]+str[0]);
			}
			
		}
	}
}