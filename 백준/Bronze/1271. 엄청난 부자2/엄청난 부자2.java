import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		BigInteger n = scanner.nextBigInteger();
		BigInteger m = scanner.nextBigInteger();
		
		System.out.println(n.divide(m));
		System.out.print(n.remainder(m));
		
		
	}
}