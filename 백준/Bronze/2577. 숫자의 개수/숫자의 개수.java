import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		long a = Long.parseLong(br.readLine());
		long b = Long.parseLong(br.readLine());
		long c = Long.parseLong(br.readLine());
		
		long mul = a*b*c;
		String mul_str = Long.toString(mul);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<mul_str.length(); i++) {
			int digit = Integer.parseInt(mul_str.substring(i, i+1));
			if(map.get(digit) == null) {
				map.put(digit, 1);
			}
			else {
				map.put(digit, map.get(digit) + 1);
			}
		}

		for(int i=0; i<10; i++) {
			if(map.get(i) == null) System.out.println(0);
			else System.out.println(map.get(i));
		}
	}
}