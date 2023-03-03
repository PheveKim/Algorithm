import java.util.*;
import java.io.*;
import java.math.*;


public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			
			int N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			int max_height = 0;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, arr[i]);
			}
			
			int day = 1;
			int max_value = 0;
			int max_idx = 0;
			int min_value = Integer.MAX_VALUE;
			int min_idx = 0;
			boolean done = false;
			while(true) {
				
			    max_value = Integer.MIN_VALUE;
			    max_idx = -1;
			    min_value = Integer.MAX_VALUE;
			    min_idx = -1;
				if(day % 2 != 0) {
					for(int i=0; i<N; i++) {
						if(arr[i] < max_height) {
							if(max_value < arr[i]) {
								if(max_height - arr[i] == 2) continue;
								max_value = arr[i];
								max_idx = i;
								done = true;
							}
						}
					}
					if(max_idx != -1) arr[max_idx] += 1;
				}
				else {
					for(int i=0; i<N; i++) {
						if(arr[i] < max_height) {
							
							if(max_value < arr[i]) {
								if(max_height - arr[i] == 2) {
									max_value = arr[i];
									max_idx = i;
									done = true;
									break;
								}
							}
							
							
							if(min_value > arr[i]) {
								if(arr[i] + 2 > max_height) continue;
								min_value = arr[i];
								min_idx = i;
							}
						}
					}
					if(max_idx != -1) arr[max_idx] += 2;
					else {
						if(min_idx != -1) arr[min_idx] += 2;
					}
					
				}
				
				boolean all_good = true;
				for(int i=0; i<N; i++) {
					if(arr[i] < max_height) all_good = false;
				}
				if(all_good) {
					break;
				}
//				System.out.println((t+1)+ "  " + day + " " + Arrays.toString(arr));
				day++;
			}
			if(day == 1 && !done) day = 0;
			bw.write("#" + (t+1) + " " + day);
			bw.newLine();
			bw.flush();
		}
		
		
	}
	
}