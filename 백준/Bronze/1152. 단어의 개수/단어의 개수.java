import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		input = input.strip();
		
		if(input.isBlank()) System.out.println(0);
		else {
			String[] words = input.split(" ");
			System.out.println(words.length);
		}
		
	}

}