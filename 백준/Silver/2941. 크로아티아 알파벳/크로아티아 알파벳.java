import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		
		//int cnt_dz, cnt_z, cnt_c1, cnt_c2, cnt_d, cnt_lj, cnt_nj, cnt_s = 0, 0;c=c=
		
		// dz=, z=, c=, c-, d-, lj, nj, s=
		int[] cnts = new int[8];
		String[] keywords = {"dz=","z=","c=","c-","d-","lj","nj","s="};
		for(int i=0; i<input.length()-2; i++) {
			if(input.substring(i,i+3).equals(keywords[0])) cnts[0]++;
		}
		for(int i=0; i<input.length()-1; i++) {
			for(int j=1; j<keywords.length; j++) {
				if(input.substring(i,i+2).equals(keywords[j])) cnts[j]++;
			}
		}
		
		int cnt_not_alphabet = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.substring(i,i+1).equals("=") || input.substring(i,i+1).equals("-")) {
				cnt_not_alphabet++;
			}
		}
		
		int answer = cnts[0] + (cnts[1] - cnts[0]) + cnts[2] + 
				cnts[3] + cnts[4] + cnts[5] + cnts[6] + cnts[7] +
				input.length() - cnt_not_alphabet - (2*cnts[0] + 
				cnts[1]-cnts[0] + cnts[2]+cnts[3]+cnts[4]+cnts[7] + 
				2*cnts[5] + 2*cnts[6]);
		
		
		
		System.out.println(answer);
		
		
		
		
		
		
	}
	
}